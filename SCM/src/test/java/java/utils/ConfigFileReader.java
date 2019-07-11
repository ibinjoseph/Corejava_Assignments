package java.utils;

import static java.utils.CommonConstants.CONFIG_PROP_FILE_PATH;
import static java.utils.CommonConstants.DATA_PROP_FILE_PATH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.ParseException;

public class ConfigFileReader {

	private static Properties properties = new Properties();

	public ConfigFileReader() {
		try (BufferedReader configReader = new BufferedReader(new FileReader(CONFIG_PROP_FILE_PATH));
				BufferedReader dataReader = new BufferedReader(new FileReader(DATA_PROP_FILE_PATH))) {
			properties.load(configReader);
			properties.load(dataReader);
		} catch (IOException e) {
			throw new ParseException(
					new StringBuilder().append("configuration.properties not found at ").append(CONFIG_PROP_FILE_PATH)
							.append(" or data.properties not found at ").append(DATA_PROP_FILE_PATH).toString());

		}
	}

	public String getProperty(String property) {
		if (properties.getProperty(property) != null) {
			return properties.getProperty(property);
		} else {
			throw new ParseException(new StringBuilder().append(property)
					.append(" not present in either configuration.properties (").append(CONFIG_PROP_FILE_PATH)
					.append(") or data.properties (").append(DATA_PROP_FILE_PATH).append(")").toString());
		}
	}

	public void replaceTestDataValue(String propertyKey, String textToReplace, String replaceValue) throws IOException {
		StringBuilder originalFileContent = new StringBuilder("");
		try (BufferedReader reader = new BufferedReader(new FileReader(DATA_PROP_FILE_PATH))) {

			String currentReadingLine = null;
			while ((currentReadingLine = reader.readLine()) != null) {
				originalFileContent
						.append(new StringBuilder().append(currentReadingLine).append(System.lineSeparator()));
			}

			writeIntoFile(originalFileContent.toString().replaceAll(textToReplace, replaceValue), DATA_PROP_FILE_PATH);
			properties.setProperty(propertyKey, replaceValue);

		} catch (IOException e) {
			throw new IOException(new StringBuilder().append("Issue while replacing ").append(textToReplace)
					.append(" with ").append(replaceValue).toString());
		}
	}

	public void writeIntoFile(String fileContent, String filePath) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
			writer.write(fileContent);
		} catch (IOException e) {
			throw new IOException("Issue while writing into file: " + filePath);
		}
	}
}
