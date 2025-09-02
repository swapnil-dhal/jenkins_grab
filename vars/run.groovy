def call(){
 sh 'sudo docker run -d -p 8000:8000 notes-app:latest'
  echo "run completed"
}
