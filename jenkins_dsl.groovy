job('jenkins DSL Job') {
    description("")
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("https://github.com/lucke-01/jenkins-tutorial.git")
                    }
                    branch('*/master')
                }
            }
            lightweight()
        }
    }
    triggers {
        scm('*/5 * * * *')
    }
    steps {
        shell('./jenkins-101-master/dsl_scripts/hello_world.sh')
    }
}