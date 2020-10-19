import logging
from custom_lib import save_artifact, save_printscreen

logging.basicConfig()
logger = logging.getLogger(__name__)
logger.setLevel(logging.INFO)

def handler(event):
    logger.info("Received event: {}".format(event))
    input_parameters = event['inputParameters']
    secret_parameters = event['secretParameters']
    logger.info("Saving artifacts")
    save_artifact()
    logger.info("Saving printscreen")
    save_printscreen()
    output = {
        'receivedInputParameters': input_parameters,
        'receivedSecretParameters': secret_parameters,
    }
    logger.info("Returning response: {}".format(output))
    return output

if __name__ == '__main__':
    handler({'inputParameters': [], 'secretParameters': []})