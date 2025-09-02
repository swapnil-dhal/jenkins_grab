def call(){
       dir('Django APP') {  // Change to subdirectory if needed
                sh '''
                    pwd
                    ls -la
                    docker build -t notes-app .
                '''
}
