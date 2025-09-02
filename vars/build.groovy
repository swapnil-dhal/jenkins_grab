def call(){
        echo "this is building the code"
        sh 'sudo docker build -t notes-app .'
        echo "build done"
}
