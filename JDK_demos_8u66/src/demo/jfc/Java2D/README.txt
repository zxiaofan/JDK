The classes for the Java2D demo are contained in the Java2Demo.jar file.  
To run the Java2D demo:

% java -jar Java2Demo.jar
   - or -
% appletviewer Java2Demo.html

Although it's not necessary to unpack the Java2Demo.jar file to run 
the demo, you may want to extract its contents if you plan to modify
any of the demo source code. To extract the contents of Java2Demo.jar, 
run this command from the Java2D directory:

    jar xvf Java2Demo.jar

Note: These instructions assume that this installation's versions of the java,
appletviewer, and jar commands are in your path.  If they aren't,
then you should either specify the complete path to the commands
or update your PATH environment variable as described in the
installation instructions for the Java(TM) SE Development Kit.


-----------------------------------------------------------------------
Introduction
-----------------------------------------------------------------------

This Java2D demo consists of a set of demos housed in one GUI 
framework that uses a JTabbedPane.  You can access different groups of 
demos by clicking the tabs at the top of the pane. There are demo 
groups for Arcs_Curves, Clipping, Colors, Composite, Fonts, Images, 
Lines, Mix, Paint, Paths and Transforms.  On the right-hand side of the 
pane, the GUI framework features individual and global controls for 
changing graphics attributes. There's also a memory-usage monitor, and 
a monitor for tracking the performance, in frames per second, of 
animation demos.


-----------------------------------------------------------------------
Tips on usage 
----------------------------------------------------------------------- 

Click on one of the tabs at the top of the pane to select a demo group.  
When you select a group, a set of surfaces is displayed, each of which 
contains one of the group's demos. At the bottom of each surface is 
a set of tools for controlling the demo.  The tools can be displayed
by selecting the Tools checkbox in the Global Controls panel or
by clicking on the slim strip of gray bumps at the bottom of the demo
panel.

If you click on a demo surface, that demo is laid out by itself. A
new icon button will appear in the demo's tools toolbar one that enables 
you to create new instances of that demo's surface. 

To run the demo continuously without user interaction, select the 
Run Window item in the Options menu and press the run button in the 
new window that's displayed.  To do this from the command line:

    java -jar Java2Demo.jar -runs=10

To view all the command line options for customizing demo runs:

    java -jar Java2Demo.jar -help

Parameters that can be used in the Java2Demo.html file inside the applet 
tag to customize demo runs:
              <param name="runs" value="10">
              <param name="delay" value="10">
              <param name="ccthread" value=" ">
              <param name="screen" value="5">
              <param name="antialias" value="true">
              <param name="rendering" value="true">
              <param name="texture" value="true">
              <param name="composite" value="true">
              <param name="verbose" value=" ">
              <param name="buffers" value="3,10">
              <param name="verbose" value=" ">
              <param name="zoom" value=" ">

You can run the demos in stand-alone mode by issuing a command like 
this from the Java2D directory:

    java -cp Java2Demo.jar java2d.demos.Clipping.ClipAnim

You can run the demos in groups by issuing a command like this from
the Java2D directory:

    java -cp Java2Demo.jar java2d.DemoGroup Clipping    

To recompile a demo, first extract the contents of the Java2Demo.jar 
file, then issue this command from the Java2D directory:

    For Win32:

        javac src\java2d\demos\Clipping\ClipAnim.java -d .

    For Solaris:

        javac src/java2d/demos/Clipping/ClipAnim.java -d .

To increase or decrease the Memory Monitor sampling rate click on the
Memory Monitor's title border, a panel with a TextField will appear.

The Java2Demo Intro (the 'Java2D' tab) contains a scene table, click in 
the gray border and a table will appear.

Animated demos have a slider to control the animation rate.  Bring up
the animated demo toolbar, then click in the gray area of the toolbar
panel, the toolbar goes away and the slider appears.

Demos that have Custom Controls can have their Custom Control Thread
activated and stopped by clicking in the gray area of the demos Custom 
Control panel.

For less garbage collection and smoother animation for the Intro and
other animated demos run with command line argument:

    java -jar -ms48m Java2Demo.jar

To allow printing of surfaces while running the demo in applet mode,
you must first run policytool to change your .java.policy file.  In 
policytool, add the permission for java.lang.RuntimePermission with a 
target name of queuePrintJob.  The .java.policy file should then include
the following:

    grant {
        permission java.lang.RuntimePermission "queuePrintJob";
    };



-----------------------------------------------------------------------
NOTE about demo surfaces 
----------------------------------------------------------------------- 

The demo groups are in separate packages with their class files stored 
in directories named according to the demo group name.  All drawing 
demos extend either the Surface, AnimatingSurface, ControlsSurface or
AnimatingControlsSurface classes.  Surface is the base class, demos
must implement the Surface's render method.  All animated demos extend 
either the AnimatingSurface or the AnimatingControlsSurface classes.  
Animated demos must implement the reset and step methods.  The demos
with gui controls extend either the ControlsSurface or the 
AnimatingControlsSurface classes.  Demos with controls must implement
the methods in the CustomControlsContext interface.


======================================================================

Many resources for learning about and using the Java2D API can be
found on the Java2D home page:

http://java.sun.com/products/java-media/2D/

That page provides links to many resources, including a complete API
Guide and Tutorial:

http://download.oracle.com/javase/tutorial/2d/
http://download.oracle.com/javase/7/docs/technotes/guides/2d/spec/j2d-bookTOC.html



Some examples, including the Java2D demo can be found on the samples
page:

http://java.sun.com/products/java-media/2D/samples/
http://java.sun.com/products/java-media/2D/samples/suite/

