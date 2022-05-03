package com.github.jsaule

import scala.io.Source
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.io.FileWriter

class Document(title:String = "", author:String = "", url:String = "", rows:Array[String] = Array[String]()) {
  val rowCount: Int = rows.length
  val wordCount: Int = JulUtil.getWordCountPerLine(rows).sum
  val firstRow = s"URL: $url \n"
  val secondRow = s"Author: $author \n"
  val thirdRow = s"Title: $title \n"
  val threeNewLines = s"\n\n\n"
  val folderForDocuments = "src/resources/texts/"
  val documentURLs = "src/resources/texts/webPages.txt"

  def addTimeStampToUrl(): String = {
    val currentDateTime = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm").format(LocalDateTime.now())
    currentDateTime
  }

  def createDocumentName: String = {
    val authorDoc = author.replace(' ', '_')
    val titleDoc = title.replace(' ', '_')
    authorDoc.slice(0, 10) + "_" + titleDoc.slice(0, 15) + "_" + addTimeStampToUrl + ".txt"
  }

  def saveURL(documentURLs: String, url: String, append:Boolean=true, verbose:Boolean=true): Unit = {
    if (verbose) println(s"Saving URL $url to $documentURLs done.")
    val fw = new FileWriter(documentURLs, append)
    if (append) fw.write("\n")
    fw.write(url)
    fw.close()
  }

  saveURL(documentURLs, url)

  def getDataLinesFromURL(url: String = ""): String = {
    val bufferedSource = Source.fromURL(url)
    bufferedSource.mkString
  }

  val text: String = getDataLinesFromURL(url)
  val rowsALL: String = firstRow + secondRow + thirdRow + threeNewLines + text
  val dst: String = folderForDocuments + createDocumentName

  def saveDocument(dst: String, rowsAll: String, append:Boolean=false, verbose:Boolean=true): Unit = {
    if (verbose) println(s"Saving document to $dst done.")
    val fw = new FileWriter(dst, append)
    if (append) fw.write("\n")
    fw.write(rowsAll)
    fw.close()
  }
  saveDocument(dst, rowsALL)

  Thread.sleep(200)
}

object TaskDocumentReadingExercise extends App {

  val test0Document = new Document("Phaedo", "Plato", "https://gutenberg.org/cache/epub/1658/pg1658.txt")
  val test1Document = new Document("Protagoras", "Plato", "https://gutenberg.org/cache/epub/1591/pg1591.txt")
}