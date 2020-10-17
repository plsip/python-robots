import logging
logging.basicConfig()
logger = logging.getLogger(__name__)
logger.setLevel(logging.INFO)

def handler(event):
    logger.info("Received event: {}".format(event))
    input_parameters = event['inputParameters']
    secret_parameters = event['secretParameters']
    output = {
        'receivedInputParameters': input_parameters,
        'receivedSecretParameters': secret_parameters,
    }
    logger.info("Returning response: {}".format(output))
    return output

if __name__ == '__main__':
    handler({'inputParameters': [], 'secretParameters': []})