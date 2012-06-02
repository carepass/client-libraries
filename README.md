CarePass iOS Client Libraries
=============================

The goal of these libraries is to remove the need for a CarePass developer to manage the baseline connectivity and data un-packing of interacting with the CarePass APIs.

About CarePass APIs
===================
Read all about the available API's at http://developer.carepass.com

Quick Start: Examples you can use
=================================
For the best example as to how to use the iOS library for the CarePass APIs, view the unit tests.

To use the library asynchronously (recommended for mobile applications), you would need to set the delegate on each request that will handle when the response returns. See the sample iOS app <https://github.com/carepass/code-samples> for an example of this implementation pattern.

Adding the CarePass iOS Client Libraries to Your Project
========================================================
To an iPhone App Project
------------------------
1. Build the CarePassFramework static library found here: <https://github.com/carepass/client-libraries/tree/iOS>
2. Right click on the .a output file in Xcode and select "Show in Finder"
3. This will usually take you to the Debug-iphoneos folder. Rather than taking that one, drag and drop the .a file from the Debug-universal folder to the Framework folder in your destination project
4. Copy the .h files from the CarePassFramework project that you will need into a Carepass folder in your project, making sure to maintain the existing folder hierarchy
5. In your target's Build Settings, update the _Header Search Paths_ to include ""$(SRCROOT)/<folder added in step 4>", making sure to check the recursive box
6. Also in your target's Build Settings, update the _Other Linker Flags_ to include "-ObjC"

You should now be able to incorporate CarePassFramework functionality into your app. If you run into any issues, review the sample iOS app.

What's missing
==============
- The error reporting is very primitive. Common causes of error include sending malformed or missing request parameters or forgetting to set your API key. A quick way to make sure it's not the request is by using the interactive documentation on the developer portal: https://developer.carepass.com/io-docs