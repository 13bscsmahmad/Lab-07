Advanced Programming: Lab 06
============================

Introduction
------------

This lab is an extension to the previous DirectoryCrawler lab.

1) It indexes more than just the file names and paths, namely:
- File size/Number of sub items in folders 
- Created Time/Modified Time
- Ownership and permission details (NOT DONE YET!)

2) Adds regex matching, so that results are MUCH faster, and can search using regular expressions.

3) Is built using the automation tool: Maven.

How to Run
----------

Run the program "DirectoryCrawlerUpdated" (<Working Directory>\DirectoryCrawlerUpdated\src\main\java\com\mycompany\directorycrawlerupdated) which will ask for a starting directory to start crawling through. Later, it will prompt for a keyword to search through.

Indices are stored: <Workdirectory>\DirectoryCrawlerUpdated.

Index:

- ContentIndex.txt: stores .txt contents
- UpdatedFileIndex.txt: Indexes file names, paths, and attributes

Github
------

https://github.com/13bscsmahmad/Lab-07