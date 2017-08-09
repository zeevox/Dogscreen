# Dogscreen
[![Download](https://api.bintray.com/packages/zeevox/Dogscreen/dogscreen-library/images/download.svg) ](https://bintray.com/zeevox/Dogscreen/dogscreen-library/_latestVersion)
[![Github license](https://img.shields.io/badge/license-MIT%20License-blue.svg)](https://github.com/ZeevoX/Dogscreen/blob/master/LICENSE)

# Table of Contents

1. [Sample Project](#sample-project)
2. [Gradle Dependency](#gradle-dependency)
3. [What's New](#whats-new)
4. [Basic Dogscreen](#basic-dogscreen)
5. [Custom Dogscreen](#custom-dogscreen)
	1. [Setting a Title](#setting-a-title)
	2. [Customizing content](#customizing-content)
6. [Confirmation button](#confirmation-button)
	1. [Default confirmation bar](#default-confirmation-bar)
	2. [FAB confirmation](#fab-confirmation)


------

# Sample Project

You can download the latest sample APK from [the releases page.](https://github.com/ZeevoX/Dogscreen/releases)

It's also on Google Play:

<a href="https://play.google.com/store/apps/details?id=com.zeevox.dogscreen.demo" target="_blank">
  <img alt="Get it on Google Play"
       src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" height="65"/>
</a>

Having the sample project installed is a good way to be notified of new releases. Although Watching this 
repository will allow GitHub to email you whenever I publish a release.

---

# Gradle Dependency

### Repository

The Gradle dependency is available via [jCenter](https://bintray.com/zeevox/Dogscreen/dogscreen-library).
jCenter is the default Maven repository used by Android Studio.

The minimum API level supported by this library is API 14 (Ice Cream Sandwich).

Add the Dogscreen dependency in your build.gradle like so:

```gradle
dependencies {
	// ... other dependencies here
    compile 'com.zeevox.dogscreen:dogscreen:2.0.0'
}
```

---

# What's New

See the project's Releases page for a list of versions with their changelogs.

### [View Releases](https://github.com/ZeevoX/Dogscreen/releases)

---

# Basic Dogscreen

First of all, note that `DogscreenActivity` extends `AppCompatActivity`, so Android Studio will show an error that multiple revisions of the Support Libraries are being used at one time.
Currently, Dogscreen uses the Android Support Libraries v26.0.1, released August 2017. I will try to update Dogscreen with the latest Support Libraries as soon as possible after new revisions are released.

Note that you can always substitute literal strings and string resources for methods that take strings.

```java
Dogscreen dogscreen = new Dogscreen(this);
dogscreen.show();
```

This will use the default values and display the default Google dogfooding notice, found in the leaked Google Duo APK.

---

# Custom Dogscreen

As this is only the first release, customizability options are rather limited. You can, however, change the title, description and type of confirmation button.

### Setting a title

To change the title, use `setTitle()`

```java
dogscreen.setTitle("Hello world!");
```

You can also pass a String ID, as such:

```java
dogscreen.setTitle(R.string.hello_world);
```

### Customizing content

To change the further information given (the "description"), use `setContent()`

```java
dogscreen.setContent("Further information given in the description of the Dogscreen")
```

You can also pass a String ID, as above.

---

	1. [Default confirmation bar](#default-confirmation-bar)
	2. [FAB confirmation](#fab-confirmation)

# Confirmation button

You can change the look of the "OK" button too, pick between the default bottom action bar with "GOT IT" text, or a FloatingActionButton (FAB) in the bottom right corner.

### Default confirmation bar

To achieve the default confirmation bar, you can either not apply this function at all, or use

```java
dogscreen.setType(Dogscreen.DOGSCREEN_DEFAULT);
```

The default may be changed in the future.

### FAB Confirmation

You can replace the bottom action bar with a FAB.
To achieve this, use

```java
dogscreen.setType(Dogscreen.DOGSCREEN_FAB);
```

---

More functions coming soon!


