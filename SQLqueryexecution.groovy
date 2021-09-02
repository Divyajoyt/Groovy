#Groovy script to script that reads a .txt file, which contains sql queries, reads the queries line-by-line and executes them.

@Grab( 'org.apache.poi:poi:3.9' )
@Grab( 'org.apache.poi:poi-ooxml:3.8')
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import groovy.sql.Sql;
import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import java.sql.Driver;
import groovy.sql.*;
import java.lang.Object;
import java.io.BufferedReader;
import java.io.FileReader;


Driver d = (Driver) Class.forName("com.microso.sqlserver.jdbc.SQLServerDriver").newInstance();
String conneconUrl = "jdbc:sqlserver://localhost;database=msdb;"
def props = new Properes()
props.setProperty("user", "sa")
props.setProperty("password", "Password@123")
def con = d.connect(conneconUrl, props);
def sql = new Sql(con)

File file = new File("C:/Users/d.kaur.virdee/Desktop/text.txt")
def lines = file.readLines()
println ("${file} has ${lines.size()} lines of text")
def n=0;
while (n!=lines.size())
{
println ("${lines[n]}");
def sqlcom = "${lines[n]}";
sql.executeUpdate("$sqlcom".toString());
n++;
}

sql.close()
