package com.github.jsaule

import scala.io.Source
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.io.FileWriter
import scala.collection.mutable.ArrayBuffer

//i am not sure if i got task correctly, so this is version 2 (i had more time to look at it and 'fix' version 1)

class Documents(title:String = "", author:String = "", url:String = "", rows:Array[String] = Array[String]()) {
  val rowCount: Int = rows.length
  val wordCount: Int = JulUtil.getWordCountPerLine(rows).sum
  val folderForDocuments = "src/resources/texts/"

  def addTimeStampToUrl(): String = {
    val currentDateTime = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm").format(LocalDateTime.now())
    currentDateTime
  }

  def createDocumentName(): String = {
    val author = JulUtil.GutenbergUtil.getAuthor(textArray).replace(' ', '_')
    val title = JulUtil.GutenbergUtil.getTitle(textArray).replace(' ', '_')
    author.slice(0, 10) + "_" + title.slice(0, 15) + "_" + addTimeStampToUrl + ".txt"
  }

  def getDataArrayFromURL(url: String): Array [String] = {
    val bufferedSource = Source.fromURL(url)
    val linesArray = bufferedSource.getLines().toArray
    bufferedSource.close()
    linesArray
  }

  var textArray: Array[String] = Array[String]()
    if (rowCount == 0) {textArray = getDataArrayFromURL(url)}
    else {textArray = rows}

  def getDataLinesFromURL(url: String = ""): String = {
    val bufferedSource = Source.fromURL(url)
    bufferedSource.mkString
  }

  var authorT = ""
  if (author == "") {authorT = JulUtil.GutenbergUtil.getAuthor(textArray)}
  else authorT = author

  var titleT = ""
  if (title == "") {titleT = JulUtil.GutenbergUtil.getTitle(textArray)}
  else titleT = title

  val firstRow = s"URL: $url \n"
  val secondRow = s"Author: $authorT \n"
  val thirdRow = s"Title: $titleT \n"
  val threeNewLines = s"\n\n\n"

  var text: String = getDataLinesFromURL(url)
  val rowsALL: String = firstRow + secondRow + thirdRow + threeNewLines + text
  var dst: String = folderForDocuments + createDocumentName

  def saveDocument(dst: String = dst, rowsALL: String = rowsALL, append:Boolean=false): Unit = {
    println(s"$url saved to $dst")
    val fw = new FileWriter(dst, append)
    if (append) fw.write("\n")
    fw.write(rowsALL)
    fw.close()
  }
}

object AssignmentDocumentReading extends App {

  var allUrlsPath = ""
  if (args.length == 0) {allUrlsPath = "src/resources/texts/webPages.txt"}
  else {allUrlsPath = args(0)}

  val readingUrls = JulUtil.getLinesFromFile(allUrlsPath)

  var urlsArray = new ArrayBuffer[String]

  val urlHTTP = "https://"
  for (line <- readingUrls) {
    if (line.contains("https://") || line.contains("http://")) urlsArray += line
    else urlsArray += urlHTTP.concat(line)
  }

  println(s"All URLs found: $urlsArray")

  for (oneURL <- urlsArray) {
    new Documents(url = oneURL).saveDocument()
    Thread.sleep(200)
  }
}