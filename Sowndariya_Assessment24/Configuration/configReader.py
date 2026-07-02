from configparser import ConfigParser
def get_config(category, key):
    config = ConfigParser()
    file_path = "Configuration/config.ini"
    config.read(file_path)
    return config.get(category, key)