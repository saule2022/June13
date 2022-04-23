package com.github.jsaule
import scala.io.Source
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Document(title:String = "", author:String = "", url:String = "", rows:Array[String] = Array[String]()) {
  val rowCount: Int = rows.length
  val wordCount: Int = JulUtil.getWordCountPerLine(rows).sum
  val firstRow = s"URL: $url"
  val secondRow = s"Author: $author"
  val thirdRow = s"Title: $title"
  val threeNewLines = s"'\n'* 3"

  def addTimeStampToUrl(): String = {
    val currentDateTime = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm").format(LocalDateTime.now())
    currentDateTime
  }

  def createDocumentName: String = {
    val author = JulUtil.GutenbergUtil.getAuthor(rows).replace(' ', '_')
    val title = JulUtil.GutenbergUtil.getTitle(rows).replace(' ', '_')
    author.slice(0, 10) + "_" + title.slice(0, 15) + "_" + addTimeStampToUrl + ".txt"
  }

  def getDataFromWeb(url: String = ""): Array[String] = {
    val bufferedSource = Source.fromURL(url)
    val dataLines = bufferedSource.getLines().toArray
    bufferedSource.close()
    dataLines
  }

  def combinedLines: Array[String] = {
    val contentLines: Array[String] = Array(firstRow, secondRow, thirdRow, threeNewLines) ++ rows
    contentLines
  }

  def save(dst: String = "", folder: String = "src/resources/texts"): Unit = {
    val lines = getDataFromWeb(url)
    val documentPath: String = if (dst == "") folder + "/" + createDocumentName else folder + "/" + dst
    JulUtil.saveLines(documentPath, lines)
  }
  Thread.sleep(200)
}

object TaskDocumentReadingExercise extends App {

  println("start")

  var filePath = ""
  if (args.length == 0) {
    filePath = "src/resources/texts/webPages.txt"
  } else {
    filePath = args(0)
  }
  val getUrls = JulUtil.getLinesFromFile(filePath)
  val urlList = for (line <- getUrls) yield {
    if (line.startsWith("http://") || line.startsWith("https://")) line
    else "https://" + line
  }
}
