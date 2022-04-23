package com.github.jsaule
import java.io.{File, FileWriter}
import java.nio.file.{Files, Paths}
import scala.io.Source

object JulUtil {

  def getWordCountPerLine(lines: Array[String], sep:String=" +"): Array[Int] = {
    val wordsLines = lines.map(_.split(sep))
    val wordsPerLine = wordsLines.map(_.length)
    wordsPerLine
  }
  def saveText(dstPath: String, text: String, append:Boolean=false, verbose:Boolean=false):Unit = {
    if (verbose) println(s"Saving ${text.length} characters to $dstPath")
    val fw = new FileWriter(dstPath, append)
    if (append) fw.write("\n")
    fw.write(text)
    fw.close()
  }
  def saveLines(dstPath: String, lines: Array[String], append:Boolean=false, lineEnd:String="\n"):Unit = {
    saveText(dstPath, lines.mkString(lineEnd), append)
  }
  object GutenbergUtil {
    def getAuthor(lines: Array[String], prefix: String = "Author:"): String = {
      val authorLines = lines.filter(_.startsWith(prefix))
      if (authorLines.length > 0) authorLines.head.replace(prefix, "").trim
      else "NO AUTHOR"

    }

    def getTitle(lines: Array[String], prefix: String = "Title:"): String = {
      val titleLines = lines.filter(_.startsWith(prefix))
      if (titleLines.length > 0) titleLines.head.replace(prefix, "").trim
      else "NO TITLE"
    }
  }
    def getLinesFromFile(src: String):Array[String] = {
      val bufferedSource = Source.fromFile(src)
      val lines = bufferedSource.getLines().toArray
      bufferedSource.close()
      lines
    }
}
