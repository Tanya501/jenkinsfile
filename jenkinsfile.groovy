pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                echo "Building ..."
            }
            post {
                always {
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
        stage ("Deploy"){
            steps {
                echo "Deploying ..."
            }
        }
        stage ("Complete"){
            steps {
                echo "Completed."
            }
        }
    }
}
