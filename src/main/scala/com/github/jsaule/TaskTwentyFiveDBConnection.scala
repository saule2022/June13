package com.github.jsaule

import java.sql.DriverManager

object TaskTwentyFiveDBConnection extends App {
 println("Testing BD connection")

  val dbPath = "src/resources/db/sql/chinook.db"
  val URL = s"jdbc:sqlite:$dbPath"

  println(s"Will connect SQLite database to the following URL: $URL")

  val connection = DriverManager.getConnection(URL) //open connection, need to close later
  println(connection.getClientInfo())

  //creating query
  val statement = connection.createStatement() //statement object, which sends SQL statements to DB
}
