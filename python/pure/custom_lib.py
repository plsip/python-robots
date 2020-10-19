import os

import requests
import pandas as pd

def save_artifact():
    with open(os.path.join(os.environ['ARTIFACTS_PATH'], "example.txt"), 'w+') as f:
        f.write("Some artifact")
        df = pd.DataFrame({
            "Name": ["John", "Doe"],
            "Age": [22, 23],
            "Sex": ["Male", "NotSpecified"],
        })
        print(df)
    return requests.get("http://google.com")


def save_printscreen():
    with open(os.path.join(os.environ['SCREENSHOTS_PATH'], "example.txt"), 'w+') as f:
        f.write("Some screenshot")
