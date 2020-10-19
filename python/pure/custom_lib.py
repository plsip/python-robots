import os

import requests

def save_artifact():
    with open(os.environ['ARTIFACTS_PATH'], 'r') as f:
        f.write("Some artifact")
    return requests.get("http://google.com")


def save_printscreen():
    with open(os.environ['ARTIFACTS_PATH'], 'r') as f:
        f.write("Some screenshot")
