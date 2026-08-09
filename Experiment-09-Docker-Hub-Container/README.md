# Experiment 09 - Running Containers from Docker Hub

## Aim
To pull, run, tag, and publish Docker containers from/to Docker Hub registry.

## Prerequisites
- Docker Engine / Docker Desktop
- Docker Hub Account

## Files
- `run_docker_hub.sh`: Bash script automating Docker Hub pull, run, tag, and push operations.
- `Dockerfile`: Sample Dockerfile for publishing to Docker Hub.

## How to Run

```bash
chmod +x run_docker_hub.sh
./run_docker_hub.sh
```

### Manual Commands:
```bash
# Pull and run standard image from Docker Hub
docker pull nginx
docker run -d -p 8080:80 nginx

# Push custom image to Docker Hub
docker login
docker tag my-app <your-username>/my-app:v1.0
docker push <your-username>/my-app:v1.0
```

## Result
Docker Hub container management operations (pulling, running, tagging, pushing) were executed successfully.
