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
    public class AllureToAzureJS
    {
        public Dictionary<string, string> finalResult;

        [Test]
        public void AllureToAzureDevops_PASSED()
        {
           // Assert.AreEqual(finalResult["117416:M:Validate user can navigate to the About Page using a menu item in the Settings menu"], "passed");

        }

        [Test]
        public void AllureToAzureDevops_FAILED()
        {
          //  Assert.AreEqual(finalResult["117416:M:Validate user can navigate to the About Page using a menu item in the Settings menu"], "failed");

        }
        [Test]
        public void AllureToAzureDevops_FAIL2()
        {
            //Assert.AreEqual(finalResult["117416:M:Validate user can navigate to the About Page using a menu item in the Settings menu"], "failed");

        }


        #region TEST FRAMEWORK (DO NOT MODIFY)


        [SetUp]
        public void TestInitialize()
        {

            /*
                finalResult = new Dictionary<string, string>();
                var filePath = "D:\\AllureReportToAzureDevops\\AllureToAzureDevOps\\Reports\\AllureReport.json";
                var manifestData = File.ReadAllText(filePath);
                var root = JsonConvert.DeserializeObject<Root2>(manifestData);
                var testResults = root;
            foreach (var result in testResults.children)
            {
                foreach (var result2 in result.children)
                {
                    Console.WriteLine("TestCaseName: "+ result2.name + " Status: "+ result2.status);
                    finalResult.Add(result2.name, result2.status);
                    
                }

            }
            */
          
        }

        
        #endregion
    }
}

// Root myDeserializedClass = JsonConvert.DeserializeObject<Root>(myJsonResponse);
public class Child2
{
    public string name { get; set; }
    public List<Child2> children { get; set; }
    public string uid { get; set; }
    public string parentUid { get; set; }
    public string status { get; set; }
    public Time time { get; set; }
    public bool flaky { get; set; }
    public List<object> parameters { get; set; }
}

public class Root2
{
    public string uid { get; set; }
    public string name { get; set; }
    public List<Child2> children { get; set; }
}

public class Time2
{
    public object start { get; set; }
    public object stop { get; set; }
    public int duration { get; set; }
}

