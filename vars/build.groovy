def call(){
      sh '''
                        pwd
                        ls -la
                        docker build -t notes-app .
                    '''
}
