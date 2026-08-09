# Experiment 04 - GAE Launcher to Launch Web Applications

## Aim
To use GAE Launcher / Google Cloud SDK to configure, serve static files, and launch web applications on Google App Engine.

## Structure
- `app.yaml`: Configures static file handlers mapping URLs to `/www/` assets.
- `www/index.html`: Web application homepage HTML.
- `www/css/style.css`: Stylesheet formatting the web application UI.

## How to Run

### 1. Serve Locally with App Engine Dev Server
```bash
dev_appserver.py app.yaml
```

### 2. Deploy and Launch via Google Cloud SDK
```bash
gcloud app deploy
gcloud app browse
```

## Sample Output
```
Browser opens: https://<project-id>.appspot.com
Renders "Hello, world! This is a simple static HTML file served from Google App Engine." with CSS styling.
```

## Result
The web application static file routing was configured using `app.yaml`, and launched successfully using GAE tools.
