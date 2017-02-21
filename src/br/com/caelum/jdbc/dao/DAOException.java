package br.com.caelum.jdbc.dao;

public class DAOException extends RuntimeException {
      public DAOException() {
          super();
      }
      public DAOException(String s) {
          super(s);
      }
      public DAOException(String s, Throwable throwable) {
          super(s, throwable);
      }
      public DAOException(Throwable throwable) {
          super(throwable);
      }
}
