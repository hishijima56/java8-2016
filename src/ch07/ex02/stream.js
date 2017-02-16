/*
 * 練習問題07_02
 */
//javaクラス定義
var String = java.lang.String
var Files = java.nio.file.Files
var Paths = java.nio.file.Paths
var Arrays = java.util.Arrays
var StandardCharsets = java.nio.charset.StandardCharsets

var contents = new String(Files.readAllBytes(Paths.get('alice.txt')), StandardCharsets.UTF_8)

var wordStream = Arrays.asList(contents.split(/\W+/)).stream()
var sortedStream = wordStream.filter(function(s){ return s.length()>12}).distinct().sorted()
sortedStream.forEach(function(s){ print(s)})