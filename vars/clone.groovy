def call(){
  dir('/home/swapnil/Desktop') {
      echo "Cloning from github.."
  git url: 'https://github.com/swapnil-dhal/django-notes-app.git', branch: 'main'
}


}
