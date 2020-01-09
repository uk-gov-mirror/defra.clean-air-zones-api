package uk.gov.caz.retrofit.service.exception;

public class CsvMaxLineLengthExceededException extends IllegalArgumentException {

  private final int lineLength;

  public CsvMaxLineLengthExceededException(String message, int lineLength) {
    super(message);
    this.lineLength = lineLength;
  }

  public int getLineLength() {
    return lineLength;
  }
}
