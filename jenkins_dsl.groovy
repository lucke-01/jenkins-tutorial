job('jenkins DSL Job') {
    description("")
    scm {
        git("https://github.com/lucke-01/jenkins-tutorial.git", master)
    }
    triggers {
        scm('*/5 * * * *')
    }
    steps {
        shell('./jenkins-101-master/dsl_scripts/hello_world.sh')
    }
}