package xyz.marcelo.common;

public class Constants
{
    public static final String DATA_FILE_PATH = "data/SMSSpamCollection";

    public static final int NUMBER_OF_REPEATS = 3;

    // public static final String METRICS_HEADER = "Sw\tLz\tLd\tNf\tCl\tHP\tSP\tHR\tSR\tERR\tACC\tWERR\tWACC\tTCR\tHFM\tSFM\tCT";

    public static final String METRICS_HEADER = "Sw\tLz\tLd\tNf\tCl\tHP\tSP\tHR\tSR\tERR\tACC\tWERR\tWACC\tTCR\tFM\tCT";

    public static final String[][] CONFIGS = {
            // Sw Lz Ld Nf Cl
            { "Yes", "Yes", "1", "8", "SVM" }, { "Yes", "Yes", "1", "8", "NB" }, { "Yes", "Yes", "1", "16", "SVM" }, { "Yes", "Yes", "1", "16", "NB" },
            { "Yes", "Yes", "1", "32", "SVM" }, { "Yes", "Yes", "1", "32", "NB" }, { "Yes", "Yes", "1", "64", "SVM" }, { "Yes", "Yes", "1", "64", "NB" },
            { "Yes", "Yes", "1", "128", "SVM" }, { "Yes", "Yes", "1", "128", "NB" }, { "Yes", "Yes", "1", "256", "SVM" }, { "Yes", "Yes", "1", "256", "NB" },
            { "Yes", "Yes", "1", "512", "SVM" }, { "Yes", "Yes", "1", "512", "NB" }, { "Yes", "Yes", "1", "1024", "SVM" }, { "Yes", "Yes", "1", "1024", "NB" },
            { "Yes", "Yes", "1", "2048", "SVM" }, { "Yes", "Yes", "1", "2048", "NB" }, { "Yes", "Yes", "1", "4096", "SVM" },
            { "Yes", "Yes", "1", "4096", "NB" }, { "Yes", "Yes", "1", "8192", "SVM" }, { "Yes", "Yes", "1", "8192", "NB" }, { "Yes", "Yes", "999", "8", "SVM" },
            { "Yes", "Yes", "999", "8", "NB" }, { "Yes", "Yes", "999", "16", "SVM" }, { "Yes", "Yes", "999", "16", "NB" }, { "Yes", "Yes", "999", "32", "SVM" },
            { "Yes", "Yes", "999", "32", "NB" }, { "Yes", "Yes", "999", "64", "SVM" }, { "Yes", "Yes", "999", "64", "NB" },
            { "Yes", "Yes", "999", "128", "SVM" }, { "Yes", "Yes", "999", "128", "NB" }, { "Yes", "Yes", "999", "256", "SVM" },
            { "Yes", "Yes", "999", "256", "NB" }, { "Yes", "Yes", "999", "512", "SVM" }, { "Yes", "Yes", "999", "512", "NB" },
            { "Yes", "Yes", "999", "1024", "SVM" }, { "Yes", "Yes", "999", "1024", "NB" }, { "Yes", "Yes", "999", "2048", "SVM" },
            { "Yes", "Yes", "999", "2048", "NB" }, { "Yes", "Yes", "999", "4096", "SVM" }, { "Yes", "Yes", "999", "4096", "NB" },
            { "Yes", "Yes", "999", "8192", "SVM" }, { "Yes", "Yes", "999", "8192", "NB" }, { "Yes", "No", "1", "8", "SVM" }, { "Yes", "No", "1", "8", "NB" },
            { "Yes", "No", "1", "16", "SVM" }, { "Yes", "No", "1", "16", "NB" }, { "Yes", "No", "1", "32", "SVM" }, { "Yes", "No", "1", "32", "NB" },
            { "Yes", "No", "1", "64", "SVM" }, { "Yes", "No", "1", "64", "NB" }, { "Yes", "No", "1", "128", "SVM" }, { "Yes", "No", "1", "128", "NB" },
            { "Yes", "No", "1", "256", "SVM" }, { "Yes", "No", "1", "256", "NB" }, { "Yes", "No", "1", "512", "SVM" }, { "Yes", "No", "1", "512", "NB" },
            { "Yes", "No", "1", "1024", "SVM" }, { "Yes", "No", "1", "1024", "NB" }, { "Yes", "No", "1", "2048", "SVM" }, { "Yes", "No", "1", "2048", "NB" },
            { "Yes", "No", "1", "4096", "SVM" }, { "Yes", "No", "1", "4096", "NB" }, { "Yes", "No", "1", "8192", "SVM" }, { "Yes", "No", "1", "8192", "NB" },
            { "Yes", "No", "999", "8", "SVM" }, { "Yes", "No", "999", "8", "NB" }, { "Yes", "No", "999", "16", "SVM" }, { "Yes", "No", "999", "16", "NB" },
            { "Yes", "No", "999", "32", "SVM" }, { "Yes", "No", "999", "32", "NB" }, { "Yes", "No", "999", "64", "SVM" }, { "Yes", "No", "999", "64", "NB" },
            { "Yes", "No", "999", "128", "SVM" }, { "Yes", "No", "999", "128", "NB" }, { "Yes", "No", "999", "256", "SVM" },
            { "Yes", "No", "999", "256", "NB" }, { "Yes", "No", "999", "512", "SVM" }, { "Yes", "No", "999", "512", "NB" },
            { "Yes", "No", "999", "1024", "SVM" }, { "Yes", "No", "999", "1024", "NB" }, { "Yes", "No", "999", "2048", "SVM" },
            { "Yes", "No", "999", "2048", "NB" }, { "Yes", "No", "999", "4096", "SVM" }, { "Yes", "No", "999", "4096", "NB" },
            { "Yes", "No", "999", "8192", "SVM" }, { "Yes", "No", "999", "8192", "NB" }, { "No", "Yes", "1", "8", "SVM" }, { "No", "Yes", "1", "8", "NB" },
            { "No", "Yes", "1", "16", "SVM" }, { "No", "Yes", "1", "16", "NB" }, { "No", "Yes", "1", "32", "SVM" }, { "No", "Yes", "1", "32", "NB" },
            { "No", "Yes", "1", "64", "SVM" }, { "No", "Yes", "1", "64", "NB" }, { "No", "Yes", "1", "128", "SVM" }, { "No", "Yes", "1", "128", "NB" },
            { "No", "Yes", "1", "256", "SVM" }, { "No", "Yes", "1", "256", "NB" }, { "No", "Yes", "1", "512", "SVM" }, { "No", "Yes", "1", "512", "NB" },
            { "No", "Yes", "1", "1024", "SVM" }, { "No", "Yes", "1", "1024", "NB" }, { "No", "Yes", "1", "2048", "SVM" }, { "No", "Yes", "1", "2048", "NB" },
            { "No", "Yes", "1", "4096", "SVM" }, { "No", "Yes", "1", "4096", "NB" }, { "No", "Yes", "1", "8192", "SVM" }, { "No", "Yes", "1", "8192", "NB" },
            { "No", "Yes", "999", "8", "SVM" }, { "No", "Yes", "999", "8", "NB" }, { "No", "Yes", "999", "16", "SVM" }, { "No", "Yes", "999", "16", "NB" },
            { "No", "Yes", "999", "32", "SVM" }, { "No", "Yes", "999", "32", "NB" }, { "No", "Yes", "999", "64", "SVM" }, { "No", "Yes", "999", "64", "NB" },
            { "No", "Yes", "999", "128", "SVM" }, { "No", "Yes", "999", "128", "NB" }, { "No", "Yes", "999", "256", "SVM" },
            { "No", "Yes", "999", "256", "NB" }, { "No", "Yes", "999", "512", "SVM" }, { "No", "Yes", "999", "512", "NB" },
            { "No", "Yes", "999", "1024", "SVM" }, { "No", "Yes", "999", "1024", "NB" }, { "No", "Yes", "999", "2048", "SVM" },
            { "No", "Yes", "999", "2048", "NB" }, { "No", "Yes", "999", "4096", "SVM" }, { "No", "Yes", "999", "4096", "NB" },
            { "No", "Yes", "999", "8192", "SVM" }, { "No", "Yes", "999", "8192", "NB" }, { "No", "No", "1", "8", "SVM" }, { "No", "No", "1", "8", "NB" },
            { "No", "No", "1", "16", "SVM" }, { "No", "No", "1", "16", "NB" }, { "No", "No", "1", "32", "SVM" }, { "No", "No", "1", "32", "NB" },
            { "No", "No", "1", "64", "SVM" }, { "No", "No", "1", "64", "NB" }, { "No", "No", "1", "128", "SVM" }, { "No", "No", "1", "128", "NB" },
            { "No", "No", "1", "256", "SVM" }, { "No", "No", "1", "256", "NB" }, { "No", "No", "1", "512", "SVM" }, { "No", "No", "1", "512", "NB" },
            { "No", "No", "1", "1024", "SVM" }, { "No", "No", "1", "1024", "NB" }, { "No", "No", "1", "2048", "SVM" }, { "No", "No", "1", "2048", "NB" },
            { "No", "No", "1", "4096", "SVM" }, { "No", "No", "1", "4096", "NB" }, { "No", "No", "1", "8192", "SVM" }, { "No", "No", "1", "8192", "NB" },
            { "No", "No", "999", "8", "SVM" }, { "No", "No", "999", "8", "NB" }, { "No", "No", "999", "16", "SVM" }, { "No", "No", "999", "16", "NB" },
            { "No", "No", "999", "32", "SVM" }, { "No", "No", "999", "32", "NB" }, { "No", "No", "999", "64", "SVM" }, { "No", "No", "999", "64", "NB" },
            { "No", "No", "999", "128", "SVM" }, { "No", "No", "999", "128", "NB" }, { "No", "No", "999", "256", "SVM" }, { "No", "No", "999", "256", "NB" },
            { "No", "No", "999", "512", "SVM" }, { "No", "No", "999", "512", "NB" }, { "No", "No", "999", "1024", "SVM" }, { "No", "No", "999", "1024", "NB" },
            { "No", "No", "999", "2048", "SVM" }, { "No", "No", "999", "2048", "NB" }, { "No", "No", "999", "4096", "SVM" },
            { "No", "No", "999", "4096", "NB" }, { "No", "No", "999", "8192", "SVM" }, { "No", "No", "999", "8192", "NB" }, { "Yes", "Yes", "1", "8", "SVM" },
            { "Yes", "Yes", "1", "8", "NB" }, { "Yes", "Yes", "1", "16", "SVM" }, { "Yes", "Yes", "1", "16", "NB" }, { "Yes", "Yes", "1", "32", "SVM" },
            { "Yes", "Yes", "1", "32", "NB" }, { "Yes", "Yes", "1", "64", "SVM" }, { "Yes", "Yes", "1", "64", "NB" }, { "Yes", "Yes", "1", "128", "SVM" },
            { "Yes", "Yes", "1", "128", "NB" }, { "Yes", "Yes", "1", "256", "SVM" }, { "Yes", "Yes", "1", "256", "NB" }, { "Yes", "Yes", "1", "512", "SVM" },
            { "Yes", "Yes", "1", "512", "NB" }, { "Yes", "Yes", "1", "1024", "SVM" }, { "Yes", "Yes", "1", "1024", "NB" }, { "Yes", "Yes", "1", "2048", "SVM" },
            { "Yes", "Yes", "1", "2048", "NB" }, { "Yes", "Yes", "1", "4096", "SVM" }, { "Yes", "Yes", "1", "4096", "NB" },
            { "Yes", "Yes", "1", "8192", "SVM" }, { "Yes", "Yes", "1", "8192", "NB" }, { "Yes", "Yes", "999", "8", "SVM" }, { "Yes", "Yes", "999", "8", "NB" },
            { "Yes", "Yes", "999", "16", "SVM" }, { "Yes", "Yes", "999", "16", "NB" }, { "Yes", "Yes", "999", "32", "SVM" },
            { "Yes", "Yes", "999", "32", "NB" }, { "Yes", "Yes", "999", "64", "SVM" }, { "Yes", "Yes", "999", "64", "NB" },
            { "Yes", "Yes", "999", "128", "SVM" }, { "Yes", "Yes", "999", "128", "NB" }, { "Yes", "Yes", "999", "256", "SVM" },
            { "Yes", "Yes", "999", "256", "NB" }, { "Yes", "Yes", "999", "512", "SVM" }, { "Yes", "Yes", "999", "512", "NB" },
            { "Yes", "Yes", "999", "1024", "SVM" }, { "Yes", "Yes", "999", "1024", "NB" }, { "Yes", "Yes", "999", "2048", "SVM" },
            { "Yes", "Yes", "999", "2048", "NB" }, { "Yes", "Yes", "999", "4096", "SVM" }, { "Yes", "Yes", "999", "4096", "NB" },
            { "Yes", "Yes", "999", "8192", "SVM" }, { "Yes", "Yes", "999", "8192", "NB" }, { "Yes", "No", "1", "8", "SVM" }, { "Yes", "No", "1", "8", "NB" },
            { "Yes", "No", "1", "16", "SVM" }, { "Yes", "No", "1", "16", "NB" }, { "Yes", "No", "1", "32", "SVM" }, { "Yes", "No", "1", "32", "NB" },
            { "Yes", "No", "1", "64", "SVM" }, { "Yes", "No", "1", "64", "NB" }, { "Yes", "No", "1", "128", "SVM" }, { "Yes", "No", "1", "128", "NB" },
            { "Yes", "No", "1", "256", "SVM" }, { "Yes", "No", "1", "256", "NB" }, { "Yes", "No", "1", "512", "SVM" }, { "Yes", "No", "1", "512", "NB" },
            { "Yes", "No", "1", "1024", "SVM" }, { "Yes", "No", "1", "1024", "NB" }, { "Yes", "No", "1", "2048", "SVM" }, { "Yes", "No", "1", "2048", "NB" },
            { "Yes", "No", "1", "4096", "SVM" }, { "Yes", "No", "1", "4096", "NB" }, { "Yes", "No", "1", "8192", "SVM" }, { "Yes", "No", "1", "8192", "NB" },
            { "Yes", "No", "999", "8", "SVM" }, { "Yes", "No", "999", "8", "NB" }, { "Yes", "No", "999", "16", "SVM" }, { "Yes", "No", "999", "16", "NB" },
            { "Yes", "No", "999", "32", "SVM" }, { "Yes", "No", "999", "32", "NB" }, { "Yes", "No", "999", "64", "SVM" }, { "Yes", "No", "999", "64", "NB" },
            { "Yes", "No", "999", "128", "SVM" }, { "Yes", "No", "999", "128", "NB" }, { "Yes", "No", "999", "256", "SVM" },
            { "Yes", "No", "999", "256", "NB" }, { "Yes", "No", "999", "512", "SVM" }, { "Yes", "No", "999", "512", "NB" },
            { "Yes", "No", "999", "1024", "SVM" }, { "Yes", "No", "999", "1024", "NB" }, { "Yes", "No", "999", "2048", "SVM" },
            { "Yes", "No", "999", "2048", "NB" }, { "Yes", "No", "999", "4096", "SVM" }, { "Yes", "No", "999", "4096", "NB" },
            { "Yes", "No", "999", "8192", "SVM" }, { "Yes", "No", "999", "8192", "NB" }, { "No", "Yes", "1", "8", "SVM" }, { "No", "Yes", "1", "8", "NB" },
            { "No", "Yes", "1", "16", "SVM" }, { "No", "Yes", "1", "16", "NB" }, { "No", "Yes", "1", "32", "SVM" }, { "No", "Yes", "1", "32", "NB" },
            { "No", "Yes", "1", "64", "SVM" }, { "No", "Yes", "1", "64", "NB" }, { "No", "Yes", "1", "128", "SVM" }, { "No", "Yes", "1", "128", "NB" },
            { "No", "Yes", "1", "256", "SVM" }, { "No", "Yes", "1", "256", "NB" }, { "No", "Yes", "1", "512", "SVM" }, { "No", "Yes", "1", "512", "NB" },
            { "No", "Yes", "1", "1024", "SVM" }, { "No", "Yes", "1", "1024", "NB" }, { "No", "Yes", "1", "2048", "SVM" }, { "No", "Yes", "1", "2048", "NB" },
            { "No", "Yes", "1", "4096", "SVM" }, { "No", "Yes", "1", "4096", "NB" }, { "No", "Yes", "1", "8192", "SVM" }, { "No", "Yes", "1", "8192", "NB" },
            { "No", "Yes", "999", "8", "SVM" }, { "No", "Yes", "999", "8", "NB" }, { "No", "Yes", "999", "16", "SVM" }, { "No", "Yes", "999", "16", "NB" },
            { "No", "Yes", "999", "32", "SVM" }, { "No", "Yes", "999", "32", "NB" }, { "No", "Yes", "999", "64", "SVM" }, { "No", "Yes", "999", "64", "NB" },
            { "No", "Yes", "999", "128", "SVM" }, { "No", "Yes", "999", "128", "NB" }, { "No", "Yes", "999", "256", "SVM" },
            { "No", "Yes", "999", "256", "NB" }, { "No", "Yes", "999", "512", "SVM" }, { "No", "Yes", "999", "512", "NB" },
            { "No", "Yes", "999", "1024", "SVM" }, { "No", "Yes", "999", "1024", "NB" }, { "No", "Yes", "999", "2048", "SVM" },
            { "No", "Yes", "999", "2048", "NB" }, { "No", "Yes", "999", "4096", "SVM" }, { "No", "Yes", "999", "4096", "NB" },
            { "No", "Yes", "999", "8192", "SVM" }, { "No", "Yes", "999", "8192", "NB" }, { "No", "No", "1", "8", "SVM" }, { "No", "No", "1", "8", "NB" },
            { "No", "No", "1", "16", "SVM" }, { "No", "No", "1", "16", "NB" }, { "No", "No", "1", "32", "SVM" }, { "No", "No", "1", "32", "NB" },
            { "No", "No", "1", "64", "SVM" }, { "No", "No", "1", "64", "NB" }, { "No", "No", "1", "128", "SVM" }, { "No", "No", "1", "128", "NB" },
            { "No", "No", "1", "256", "SVM" }, { "No", "No", "1", "256", "NB" }, { "No", "No", "1", "512", "SVM" }, { "No", "No", "1", "512", "NB" },
            { "No", "No", "1", "1024", "SVM" }, { "No", "No", "1", "1024", "NB" }, { "No", "No", "1", "2048", "SVM" }, { "No", "No", "1", "2048", "NB" },
            { "No", "No", "1", "4096", "SVM" }, { "No", "No", "1", "4096", "NB" }, { "No", "No", "1", "8192", "SVM" }, { "No", "No", "1", "8192", "NB" },
            { "No", "No", "999", "8", "SVM" }, { "No", "No", "999", "8", "NB" }, { "No", "No", "999", "16", "SVM" }, { "No", "No", "999", "16", "NB" },
            { "No", "No", "999", "32", "SVM" }, { "No", "No", "999", "32", "NB" }, { "No", "No", "999", "64", "SVM" }, { "No", "No", "999", "64", "NB" },
            { "No", "No", "999", "128", "SVM" }, { "No", "No", "999", "128", "NB" }, { "No", "No", "999", "256", "SVM" }, { "No", "No", "999", "256", "NB" },
            { "No", "No", "999", "512", "SVM" }, { "No", "No", "999", "512", "NB" }, { "No", "No", "999", "1024", "SVM" }, { "No", "No", "999", "1024", "NB" },
            { "No", "No", "999", "2048", "SVM" }, { "No", "No", "999", "2048", "NB" }, { "No", "No", "999", "4096", "SVM" },
            { "No", "No", "999", "4096", "NB" }, { "No", "No", "999", "8192", "SVM" }, { "No", "No", "999", "8192", "NB" }, { "Yes", "Yes", "1", "8", "SVM" },
            { "Yes", "Yes", "1", "8", "NB" }, { "Yes", "Yes", "1", "16", "SVM" }, { "Yes", "Yes", "1", "16", "NB" }, { "Yes", "Yes", "1", "32", "SVM" },
            { "Yes", "Yes", "1", "32", "NB" }, { "Yes", "Yes", "1", "64", "SVM" }, { "Yes", "Yes", "1", "64", "NB" }, { "Yes", "Yes", "1", "128", "SVM" },
            { "Yes", "Yes", "1", "128", "NB" }, { "Yes", "Yes", "1", "256", "SVM" }, { "Yes", "Yes", "1", "256", "NB" }, { "Yes", "Yes", "1", "512", "SVM" },
            { "Yes", "Yes", "1", "512", "NB" }, { "Yes", "Yes", "1", "1024", "SVM" }, { "Yes", "Yes", "1", "1024", "NB" }, { "Yes", "Yes", "1", "2048", "SVM" },
            { "Yes", "Yes", "1", "2048", "NB" }, { "Yes", "Yes", "1", "4096", "SVM" }, { "Yes", "Yes", "1", "4096", "NB" },
            { "Yes", "Yes", "1", "8192", "SVM" }, { "Yes", "Yes", "1", "8192", "NB" }, { "Yes", "Yes", "999", "8", "SVM" }, { "Yes", "Yes", "999", "8", "NB" },
            { "Yes", "Yes", "999", "16", "SVM" }, { "Yes", "Yes", "999", "16", "NB" }, { "Yes", "Yes", "999", "32", "SVM" },
            { "Yes", "Yes", "999", "32", "NB" }, { "Yes", "Yes", "999", "64", "SVM" }, { "Yes", "Yes", "999", "64", "NB" },
            { "Yes", "Yes", "999", "128", "SVM" }, { "Yes", "Yes", "999", "128", "NB" }, { "Yes", "Yes", "999", "256", "SVM" },
            { "Yes", "Yes", "999", "256", "NB" }, { "Yes", "Yes", "999", "512", "SVM" }, { "Yes", "Yes", "999", "512", "NB" },
            { "Yes", "Yes", "999", "1024", "SVM" }, { "Yes", "Yes", "999", "1024", "NB" }, { "Yes", "Yes", "999", "2048", "SVM" },
            { "Yes", "Yes", "999", "2048", "NB" }, { "Yes", "Yes", "999", "4096", "SVM" }, { "Yes", "Yes", "999", "4096", "NB" },
            { "Yes", "Yes", "999", "8192", "SVM" }, { "Yes", "Yes", "999", "8192", "NB" }, { "Yes", "No", "1", "8", "SVM" }, { "Yes", "No", "1", "8", "NB" },
            { "Yes", "No", "1", "16", "SVM" }, { "Yes", "No", "1", "16", "NB" }, { "Yes", "No", "1", "32", "SVM" }, { "Yes", "No", "1", "32", "NB" },
            { "Yes", "No", "1", "64", "SVM" }, { "Yes", "No", "1", "64", "NB" }, { "Yes", "No", "1", "128", "SVM" }, { "Yes", "No", "1", "128", "NB" },
            { "Yes", "No", "1", "256", "SVM" }, { "Yes", "No", "1", "256", "NB" }, { "Yes", "No", "1", "512", "SVM" }, { "Yes", "No", "1", "512", "NB" },
            { "Yes", "No", "1", "1024", "SVM" }, { "Yes", "No", "1", "1024", "NB" }, { "Yes", "No", "1", "2048", "SVM" }, { "Yes", "No", "1", "2048", "NB" },
            { "Yes", "No", "1", "4096", "SVM" }, { "Yes", "No", "1", "4096", "NB" }, { "Yes", "No", "1", "8192", "SVM" }, { "Yes", "No", "1", "8192", "NB" },
            { "Yes", "No", "999", "8", "SVM" }, { "Yes", "No", "999", "8", "NB" }, { "Yes", "No", "999", "16", "SVM" }, { "Yes", "No", "999", "16", "NB" },
            { "Yes", "No", "999", "32", "SVM" }, { "Yes", "No", "999", "32", "NB" }, { "Yes", "No", "999", "64", "SVM" }, { "Yes", "No", "999", "64", "NB" },
            { "Yes", "No", "999", "128", "SVM" }, { "Yes", "No", "999", "128", "NB" }, { "Yes", "No", "999", "256", "SVM" },
            { "Yes", "No", "999", "256", "NB" }, { "Yes", "No", "999", "512", "SVM" }, { "Yes", "No", "999", "512", "NB" },
            { "Yes", "No", "999", "1024", "SVM" }, { "Yes", "No", "999", "1024", "NB" }, { "Yes", "No", "999", "2048", "SVM" },
            { "Yes", "No", "999", "2048", "NB" }, { "Yes", "No", "999", "4096", "SVM" }, { "Yes", "No", "999", "4096", "NB" },
            { "Yes", "No", "999", "8192", "SVM" }, { "Yes", "No", "999", "8192", "NB" }, { "No", "Yes", "1", "8", "SVM" }, { "No", "Yes", "1", "8", "NB" },
            { "No", "Yes", "1", "16", "SVM" }, { "No", "Yes", "1", "16", "NB" }, { "No", "Yes", "1", "32", "SVM" }, { "No", "Yes", "1", "32", "NB" },
            { "No", "Yes", "1", "64", "SVM" }, { "No", "Yes", "1", "64", "NB" }, { "No", "Yes", "1", "128", "SVM" }, { "No", "Yes", "1", "128", "NB" },
            { "No", "Yes", "1", "256", "SVM" }, { "No", "Yes", "1", "256", "NB" }, { "No", "Yes", "1", "512", "SVM" }, { "No", "Yes", "1", "512", "NB" },
            { "No", "Yes", "1", "1024", "SVM" }, { "No", "Yes", "1", "1024", "NB" }, { "No", "Yes", "1", "2048", "SVM" }, { "No", "Yes", "1", "2048", "NB" },
            { "No", "Yes", "1", "4096", "SVM" }, { "No", "Yes", "1", "4096", "NB" }, { "No", "Yes", "1", "8192", "SVM" }, { "No", "Yes", "1", "8192", "NB" },
            { "No", "Yes", "999", "8", "SVM" }, { "No", "Yes", "999", "8", "NB" }, { "No", "Yes", "999", "16", "SVM" }, { "No", "Yes", "999", "16", "NB" },
            { "No", "Yes", "999", "32", "SVM" }, { "No", "Yes", "999", "32", "NB" }, { "No", "Yes", "999", "64", "SVM" }, { "No", "Yes", "999", "64", "NB" },
            { "No", "Yes", "999", "128", "SVM" }, { "No", "Yes", "999", "128", "NB" }, { "No", "Yes", "999", "256", "SVM" },
            { "No", "Yes", "999", "256", "NB" }, { "No", "Yes", "999", "512", "SVM" }, { "No", "Yes", "999", "512", "NB" },
            { "No", "Yes", "999", "1024", "SVM" }, { "No", "Yes", "999", "1024", "NB" }, { "No", "Yes", "999", "2048", "SVM" },
            { "No", "Yes", "999", "2048", "NB" }, { "No", "Yes", "999", "4096", "SVM" }, { "No", "Yes", "999", "4096", "NB" },
            { "No", "Yes", "999", "8192", "SVM" }, { "No", "Yes", "999", "8192", "NB" }, { "No", "No", "1", "8", "SVM" }, { "No", "No", "1", "8", "NB" },
            { "No", "No", "1", "16", "SVM" }, { "No", "No", "1", "16", "NB" }, { "No", "No", "1", "32", "SVM" }, { "No", "No", "1", "32", "NB" },
            { "No", "No", "1", "64", "SVM" }, { "No", "No", "1", "64", "NB" }, { "No", "No", "1", "128", "SVM" }, { "No", "No", "1", "128", "NB" },
            { "No", "No", "1", "256", "SVM" }, { "No", "No", "1", "256", "NB" }, { "No", "No", "1", "512", "SVM" }, { "No", "No", "1", "512", "NB" },
            { "No", "No", "1", "1024", "SVM" }, { "No", "No", "1", "1024", "NB" }, { "No", "No", "1", "2048", "SVM" }, { "No", "No", "1", "2048", "NB" },
            { "No", "No", "1", "4096", "SVM" }, { "No", "No", "1", "4096", "NB" }, { "No", "No", "1", "8192", "SVM" }, { "No", "No", "1", "8192", "NB" },
            { "No", "No", "999", "8", "SVM" }, { "No", "No", "999", "8", "NB" }, { "No", "No", "999", "16", "SVM" }, { "No", "No", "999", "16", "NB" },
            { "No", "No", "999", "32", "SVM" }, { "No", "No", "999", "32", "NB" }, { "No", "No", "999", "64", "SVM" }, { "No", "No", "999", "64", "NB" },
            { "No", "No", "999", "128", "SVM" }, { "No", "No", "999", "128", "NB" }, { "No", "No", "999", "256", "SVM" }, { "No", "No", "999", "256", "NB" },
            { "No", "No", "999", "512", "SVM" }, { "No", "No", "999", "512", "NB" }, { "No", "No", "999", "1024", "SVM" }, { "No", "No", "999", "1024", "NB" },
            { "No", "No", "999", "2048", "SVM" }, { "No", "No", "999", "2048", "NB" }, { "No", "No", "999", "4096", "SVM" },
            { "No", "No", "999", "4096", "NB" }, { "No", "No", "999", "8192", "SVM" }, { "No", "No", "999", "8192", "NB" } };
}
