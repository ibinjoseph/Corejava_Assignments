package java.utils;

public class CommonConstants {

	private CommonConstants() {
		throw new IllegalStateException("Common Constants");
	}

	public static final String URL = "URL";
	public static final String MFL_URL = "MasterFieldLibraryURL";
	public static final String DRIVER_PATH = "DriverPath";
	public static final String UNIQUE_APP_VERSION = "UniqueAppVersion";
	public static final String APP_VERSION = "AppVersion";
	public static final String APP_DESC = "AppDesc";
	public static final String VALUE_ATTRIBUTE = "value";
	public static final String APP_DESCRIPTION = "APP_DESCRIPTION";
	public static final String APP_ID = "AppID";
	public static final String APP_ID_FEWER_PAGES = "AppIDFewerPages";
	public static final String APP_STATUS = "AppStatus";
	public static final String APP_NAME = "AppName";
	public static final String FILE_PATH = "FilePath";
	public static final String FILE_PATH_SMALLER_APP = "SmallerAppFilePath";
	public static final String APP_ID_INCORRECT_FORMAT = "AppIDInCorrectFormat";
	public static final String LARGE_TEXT = "LargeText";
	public static final String STARTING_INDEX = "StartingIndex";
	public static final String PDF_EACH_PAGE_COUNT = "PDFEachPageCount";
	public static final String SMALLER_PDF_EACH_PAGE_COUNT = "SmallerPDFEachPageCount";
	public static final String VERSION_ATTRIBUTE_NAME = "VersionAttributeName";
	public static final String EXPORT_CSV_APP_SUMMARY = "ExportCSVApplicationSummary";
	public static final String EXPORT_CSV_MFL = "ExportCSVMasterFieldLibrary";
	public static final String EXPORT_CSV_DIFF_REPORT = "ExportCSVDifferenceReport";
	public static final String CHANGE_DOWNLOAD_PATH_COMMAND = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main\" /F /V \"Default Download Directory\" /T REG_SZ /D ";
	public static final String PATH = new StringBuilder().append("\"").append(System.getProperty("user.dir"))
			.append("\\target\\downloads").append("\"").toString();
	public static final String DOWNLOAD_PATH = System.getProperty("user.dir") + "\\target\\downloads";
	public static final String WAIT_TIME = "WaitTime";
	public static final String SHORT_WAIT = "ShortWaitTime";
	public static final String REPORT_CONFIG_PATH = "ReportConfigPath";
	public static final String UNIQUE_APP_ID = "UniqueAppID";
	public static final String NEW_APP_VERSION = "NewAppVersion";
	public static final String NEW_START_INDEX = "NewStartIndex";
	public static final String FILE_PATH1 = "VersionDropdownTestDataFilePath1";
	public static final String FILE_PATH2 = "VersionDropdownTestDataFilePath2";
	public static final String FORM_NAME1 = "FormName1";
	public static final String APPLICATION_SUMMARY_GRID_COLUMN_NAMES = "ApplicationSummaryGridColumnNames";
	public static final String CONFIG_PROP_FILE_PATH = "inputData//configuration.properties";
	public static final String DATA_PROP_FILE_PATH = "inputData//data.properties";
	public static final String ADDITIONAL_PROPERTIES = "AdditionalProperties";
	public static final String ZERO_WAIT_TIME = "NoWaitTime";
	public static final String NEW_FIELD_TYPE = "NewFieldType";
	public static final String FIELD_TYPE_VALUE_FROM_DROPDOWN = "FieldTypeFromDropDown";
	public static final String VIEW_DEPENDENCIES_COLUMN_HEADERS = "ViewDependenciesColumHeaders";
	public static final String NEWLY_ADDED_FIELD_NAME = "NewlyAddedFieldName";
	public static final String INVALID_DATA_FOR_SEARCH = "InvalidDataForSearch";
	public static final String INCORRECT_FILE = "IncorrectFilePath";
	public static final String APP_ID_FOR_DELETE = "AppIDForDelete";
	public static final String CORRUPT_FILE_PATH = "CorruptFilePath";
	public static final String EMPTY_FILE_PATH = "EmptyFile";
	public static final String INVALID_FILE_PATH = "InvalidFile";
	public static final String VALID_FILE_PATH = "ValidFile";
	public static final String APP_ID_MIGRATE_INDEXES = "AppIDMigrateIndexes";
	public static final String EXPORT_IMAGE_DOWNLOAD_LINK = "ExportImageDownloadLink";
	public static final String JSON_TEMPLATE_KEYS = "JSONTemplateKeys";
	public static final String AUTOMATION_LIST_NAME = "ListName";
	public static final String AUTOMATION_LIST_VALUE1 = "ListValue1";
    public static final String AUTOMATION_LIST_VALUE2 = "ListValue2";
    public static final String MFLGRID_COLUMNS_ASSIGN_LIST = "MFLGridColumnsAssignList";
    public static final String MFLGRID_COLUMNS_COLUMN_ID_ATTRIBUTE = "MFLGridColumnsColumnId";
}
