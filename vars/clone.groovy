def call(){
  sh 'cd ~/Desktop'
  echo "Cloning from github.."
  sh 'git clone https://github.com/swapnil-dhal/django-notes-app.git'
  sh 'cd ~/Desktop/django-notes-app'
  sh 'pwd'
}
