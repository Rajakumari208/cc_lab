#!/bin/bash
# Experiment 9: Run a Container from Docker Hub
# This script demonstrates pulling and running containers from Docker Hub.

echo "============================="
echo " Docker Hub Container Lab"
echo "============================="

# Check Docker version
echo ""
echo "[Step 0] Check Docker version:"
docker version

echo ""
echo "[Step 1] Run Ubuntu container with 'top' command:"
echo "Command: docker container run -it ubuntu top"
echo "(Run this interactively in terminal - opens a TTY)"
# docker container run -it ubuntu top

echo ""
echo "[Step 2] List running containers:"
docker container ls

echo ""
echo "[Step 3] Run Nginx web server (detached, port 8080):"
docker container run --detach --publish 8080:80 --name nginx_server nginx
echo "Nginx is now running on http://localhost:8080"

echo ""
echo "[Step 4] Run MongoDB server (detached, port 8081):"
docker container run --detach --publish 8081:27017 --name mongo_server mongo:4.4
echo "MongoDB is now running on localhost:8081"

echo ""
echo "[Step 5] List all running containers:"
docker container ls

echo ""
echo "[Step 6] Inspect a running container (nginx):"
docker container inspect nginx_server

echo ""
echo "[Step 7] Execute bash inside nginx container:"
echo "Command: docker container exec -it nginx_server bash"
# docker container exec -it nginx_server bash

echo ""
echo "[Step 8] Check logs of nginx container:"
docker logs nginx_server

echo ""
echo "[Step 9] Stop all running containers:"
docker container stop nginx_server mongo_server
echo "Containers stopped."

echo ""
echo "[Step 10] Clean up stopped containers and unused images:"
docker system prune -f
echo "System pruned."

echo ""
echo "Docker Hub container experiment completed successfully."
