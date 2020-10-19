import os

def save_artifact():
    with open(os.environ['ARTIFACTS_PATH'], 'r') as f:
        f.write("Some artifact")

def save_printscreen():
    with open(os.environ['ARTIFACTS_PATH'], 'r') as f:
        f.write("Some screenshot")
