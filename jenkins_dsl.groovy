//here we can create jira jobs as many as we want using job keyword
job('Job Created FROM "Job DSL creator"') {
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