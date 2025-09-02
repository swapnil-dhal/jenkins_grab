def call(){
        echo "this is building the code"
        sh 'cd /django-notes-app'
        sh 'docker build -t notes-app .'
        echo "build done"
}
