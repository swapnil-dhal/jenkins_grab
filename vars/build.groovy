def call(){
        echo "this is building the code"
        sh 'docker build -t notes-app .'
        echo "build done"
}
