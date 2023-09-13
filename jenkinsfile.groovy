pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                echo "Buildings  ..."
            }
            post {
                always {
                    emailext attachLog: true,
                    mail to: "netanya.antony@gmail.com",
                    subject: "Build Status Email",
                    body: "Build log attached!"
                }
            }
        }
        stage ("Test"){
            steps {
                echo "Testing ..."
            }
         }
             post{
                 always {
                    emailext attachLog: true,
                    mail to: "netanya.antony@gmail.com",
                    subject: "Test Status Email",
                    body: "Test log attached!"
                }
            }
        }
        stage ("Deploy"){
            steps {
                echo "Deploying ..."
            }
         }
             post{
                 always {
                   emailext attachLog: true,
                    mail to: "netanya.antony@gmail.com",
                    subject: "Deploy Status Email",
                    body: "Deploy log attached!"
                }
            }
        }
        stage ("Complete"){
            steps {
                echo "Completed."
            }
        }
    }
    post{
       always {
            emailext attachLog: true,
               to: "netanya.antony@gmail.com",
            subject: "Completed Status Email",
            body: "Completed log attached!"
        } 
    }

}
