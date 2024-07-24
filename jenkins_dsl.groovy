job('jenkins DSL Job') {
    description("test")
    scm {
        git {
            remote {
                url("https://github.com/lucke-01/jenkins-tutorial.git")
            }
            branch('*/master')
        }
    }
    triggers {
        scm('*/5 * * * *')
    }
    steps {
        shell('./jenkins-101-master/dsl_scripts/hello_world.sh')
    }
}