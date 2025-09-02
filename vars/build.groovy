def call(){
           sh '''
                    cd Django APP/
                    pwd
                    ls -la
                    docker build -t notes-app .
                '''

}
