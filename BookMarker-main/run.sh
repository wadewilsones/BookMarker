#!/bin/bash


function build_api(){
  ./mvnw clean package -DskipTests
}

function start_cpm(){
  echo "Starting docker containers"
  docker-compose up
}

function stop_cmp(){
  echo "Stopping containers"
  docker-compose stop
}

function start(){
  build_api
  start_cpm
 echo "Starting all containers"
}

function updateRemote(){
  git add .
  echo "Enter Comment: "
  read comment
  git commit -m "${comment}"
  git push origin main
}

action="start"
if [ "$1" == "start" ]; then
 start
elif [ "$1" == "commit" ]; then
  updateRemote
