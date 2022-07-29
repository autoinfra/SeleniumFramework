using Newtonsoft.Json;
//using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.IO;

namespace KDI.Pnext.IDP
{
    [TestFixture]
   // [Ignore("Till Authorization Issue is Resolved")]
    public class AllureToAzure 
    {
        public Dictionary<string, string> finalResult;
        public String _RootDirectory = string.Empty;
        private static string testDirectory = Directory.GetCurrentDirectory();

        private String _AllureResultsPath = String.Empty;
        private String _AllureTestCaseResultsPath = String.Empty;

        public String testResults2 = String.Empty;
        public string RunnerRootDirectory
        {

            get
            {
                if (_RootDirectory.Equals(string.Empty))
                {
                    var projFilePath = Path.GetFullPath(Path.Combine(testDirectory, @"..\..\"));
                    var tmpPath = Path.GetDirectoryName(System.Reflection.Assembly.GetAssembly(typeof(AllureToAzure)).Location);
                    if (Directory.Exists(projFilePath) && Directory.GetFiles(projFilePath, "*.csproj").Length > 0)
                    {
                        _RootDirectory = Path.GetFullPath(Path.Combine(testDirectory, @"..\..\..\"));
                        return _RootDirectory;
                    }
                    _RootDirectory = Path.GetDirectoryName(System.Reflection.Assembly.GetAssembly(typeof(AllureToAzure)).Location);
                }
                return _RootDirectory;
            }
            private set { }
        }

        public string AllureResultsPath
        {
            get
            {
                if (_AllureResultsPath.Equals(string.Empty))
                {
                    _AllureResultsPath = Path.GetFullPath(RunnerRootDirectory.TrimEnd('\\') + @"\Reports\suites.json");
                }
                Console.WriteLine("Run Feeds Path:" + _AllureResultsPath);
                return _AllureResultsPath;
            }
            private set { }
        }


        public string AllureTestCaseResultsPath
        {
            get
            {
                if (_AllureTestCaseResultsPath.Equals(string.Empty))
                {
                    _AllureTestCaseResultsPath = Path.GetFullPath(RunnerRootDirectory.TrimEnd('\\') + @"\Reports\ce166715fafff72b.json");
                }
                Console.WriteLine("Run Feeds Path:" + _AllureTestCaseResultsPath);
                return _AllureTestCaseResultsPath;
            }
            private set { }
        }


        [Test]
        public void searchInDuckDuckGo()
        {
             Assert.AreEqual(finalResult["Energy budget: Get vessel group"], "passed");
        }
        [Test]
        public void SearchFailTC()
        {
            Assert.AreEqual(finalResult["Energy budget: Get vessel group"], "failed", testResults2);

        }


        #region TEST FRAMEWORK (DO NOT MODIFY)


        [SetUp]
        public void TestInitialize()
        {

                finalResult = new Dictionary<string, string>();
                //var filePath = @".\suites2.json";
               // var currentDir= Directory.GetCurrentDirectory();
               //  var filePath = Path.Combine(currentDir, "Reports", "suites.json");
                var manifestData = File.ReadAllText(AllureResultsPath);
                var root = JsonConvert.DeserializeObject<Root>(manifestData);
                var testResults = root.children[0].children[0].children[0];
                foreach (var result in testResults.children)
                {
               // Console.WriteLine("TestCaseName: " + result.name + " Status: " + result.status);
                finalResult.Add(result.name, result.status);
                }

            var manifestDataFail = File.ReadAllText(AllureTestCaseResultsPath);
            var root2 = JsonConvert.DeserializeObject<TestCaseMain>(manifestDataFail);
            testResults2 = root2.statusTrace;
            
              //  Console.WriteLine("STACK TRACE : " + testResults2);
             

        }



        #endregion
    }
}

public class Child
{
    public string name { get; set; }
    public List<Child> children { get; set; }
    public string uid { get; set; }
    public string parentUid { get; set; }
    public string status { get; set; }
    public Time time { get; set; }
    public bool flaky { get; set; }
    public bool newFailed { get; set; }
    public bool newPassed { get; set; }
    public bool newBroken { get; set; }
    public int retriesCount { get; set; }
    public bool retriesStatusChange { get; set; }
    public List<string> parameters { get; set; }
}

public class Root
{
    public string uid { get; set; }
    public string name { get; set; }
    public List<Child> children { get; set; }
}

public class Time
{
    public object start { get; set; }
    public object stop { get; set; }
    public int duration { get; set; }
}

/// TestCases Deserializers
/// 
// Root myDeserializedClass = JsonConvert.DeserializeObject<Root>(myJsonResponse);
public class Attachment
{
    public string uid { get; set; }
    public string name { get; set; }
    public string source { get; set; }
    public string type { get; set; }
    public int size { get; set; }
}

public class BeforeStage
{
    public string name { get; set; }
    public Time time { get; set; }
    public string description { get; set; }
    public string status { get; set; }
    public List<object> steps { get; set; }
    public List<object> attachments { get; set; }
    public List<object> parameters { get; set; }
    public int stepsCount { get; set; }
    public bool hasContent { get; set; }
    public int attachmentsCount { get; set; }
    public bool shouldDisplayMessage { get; set; }
}

public class Category
{
    public string name { get; set; }
    public List<object> matchedStatuses { get; set; }
    public bool flaky { get; set; }
}

public class Extra
{
    public string severity { get; set; }
    public List<Retry> retries { get; set; }
    public List<Category> categories { get; set; }
    public List<object> tags { get; set; }
}

public class Label
{
    public string name { get; set; }
    public string value { get; set; }
}

public class Link
{
    public string name { get; set; }
    public string url { get; set; }
}

public class Parameter
{
    public string name { get; set; }
    public string value { get; set; }
}

public class Retry
{
    public string uid { get; set; }
    public string status { get; set; }
    public string statusDetails { get; set; }
    public Time time { get; set; }
}

public class TestCaseMain
{
    public string uid { get; set; }
    public string name { get; set; }
    public string fullName { get; set; }
    public string historyId { get; set; }
    public TimeExecution time { get; set; }
    public string status { get; set; }
    public string statusMessage { get; set; }
    public string statusTrace { get; set; }
    public bool flaky { get; set; }
    public bool newFailed { get; set; }
    public bool newBroken { get; set; }
    public bool newPassed { get; set; }
    public int retriesCount { get; set; }
    public bool retriesStatusChange { get; set; }
    public List<BeforeStage> beforeStages { get; set; }
    public TestStage testStage { get; set; }
    public List<object> afterStages { get; set; }
    public List<Label> labels { get; set; }
    public List<Parameter> parameters { get; set; }
    public List<Link> links { get; set; }
    public bool hidden { get; set; }
    public bool retry { get; set; }
    public Extra extra { get; set; }
    public string source { get; set; }
    public List<string> parameterValues { get; set; }
}

public class TestStage
{
    public string status { get; set; }
    public string statusMessage { get; set; }
    public string statusTrace { get; set; }
    public List<object> steps { get; set; }
    public List<Attachment> attachments { get; set; }
    public List<object> parameters { get; set; }
    public int stepsCount { get; set; }
    public bool hasContent { get; set; }
    public int attachmentsCount { get; set; }
    public bool shouldDisplayMessage { get; set; }
}

public class TimeExecution
{
    public long start { get; set; }
    public long stop { get; set; }
    public int duration { get; set; }
}

