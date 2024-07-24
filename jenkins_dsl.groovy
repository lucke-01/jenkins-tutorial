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
        scm('*/40 * * * *')
    }
    wrappers {
        credentialsBinding {
            usernamePassword('USER_PASS_JIRA_USER', 'USER_PASS_JIRA_TOKEN', 'JIRA_CREDENTIALS')
        }
    }
    steps {
        shell('chmod 777 ./dsl_scripts/hello_world.sh')
        shell('./dsl_scripts/hello_world.sh')
    }
}