# selenium648PageFactory
<a href="https://softserve.academy/"><img src="https://github.com/ita-social-projects/TeachUA/blob/main/images/logo.png" title="SoftServe IT Academy" alt="SoftServe IT Academy"></a>

# Repository Title Goes Here

> Subtitle or Short Description Goes Here

> ideally one sentence

> include terms/tags that can be searched

**Badges will go here**
- build status
- issues 
- Open Pull Request
- Closed Pull Request
- license
- etc.

[![Build Status](https://img.shields.io/github/workflow/status/ita-social-projects/TeachUA_TA/allure-testng-maven)](https://github.com/ita-social-projects/TeachUA_TA/actions/workflows/allure-testng-maven.yml)
[![Github Issues](https://img.shields.io/github/issues/ita-social-projects/TeachUA_TA)](https://github.com/ita-social-projects/TeachUA_TA/issues)
[![Pending Pull-Requests](https://img.shields.io/github/issues-pr/ita-social-projects/TeachUA_TA)](https://github.com/ita-social-projects/TeachUA_TA/pulls)
[![Closed Pull-Requests](https://img.shields.io/github/issues-pr-closed/ita-social-projects/TeachUA_TA)](https://github.com/ita-social-projects/TeachUA_TA/pulls?q=is%3Apr+is%3Aclosed)
[![License](https://img.shields.io/github/license/ita-social-projects/TeachUA_TA)](http://badges.mit-license.org)


- For more on these wonderful  badges, refer to <a href="https://shields.io/" target="_blank">shields.io</a>.

---

## Table of Contents (Optional)

> If your `README` has a lot of info, section headers might be nice.

- [Installation](#installation)
  - [Required to install](#Required-to-install)
  - [Environment](#Environment)
  - [Clone](#Clone)
  - [How to run local](#How-to-run-local)
  - [Properties](#Properties)
- [Contributing](#contributing)
  - [git flow](#git-flow)
- [Support](#support)
- [License](#license)

---

## Installation

- All the `code` required to get started

### Required to install
* Java(1.8)
* Maven(3.8.2)
* Allure(2.17.2)

### Environment
environmental variables
```properties
 BASE_URL=${secrets.BASE_URL}
 ADMIN_EMAIL=${secrets.ADMIN_EMAIL}
 ADMIN_PASSWORD=${secrets.ADMIN_PASSWORD}
 TEST_TEACH_UA_META_EMAIL=${secrets.TEST_TEACH_UA_META_EMAIL}
 TEST_TEACH_UA_META_PASSWORD=${secrets.TEST_TEACH_UA_META_PASSWORD}
```

### Clone

- Clone this repo to your local machine using `https://github.com/ita-social-projects/TeachUA_TA.git`

### How to run local
---
- mvn test
### Properties

create in `src/test/resources` file  `data.properties`

```
baseURL=https://example.org.ua
adminEmail=example@test.com
adminPassword=example
```


## Contributing

### Git flow
> To get started...
#### Step 1

- **Option 1**
    - 🍴 Fork this repo!

- **Option 2**
    - 👯 Clone this repo to your local machine using `https://github.com/ita-social-projects/TeachUA_TA.git`

#### Step 2

- 🔃 Create a new pull request using <a href="https://github.com/ita-social-projects/TeachUA_TA/compare/" target="_blank">github.com/ita-social-projects/SOMEREPO</a>.

## Team

> Or Contributors/People
> 
[![@lhalam](https://avatars3.githubusercontent.com/u/3837059?s=100&v=4)](https://github.com/Mykhailo5)
[![@lhalam](https://avatars.githubusercontent.com/u/89529887?s=100&v=4)](https://github.com/vy1989)
[![@lhalam](https://avatars.githubusercontent.com/u/39509993?s=100&v=4)](https://github.com/AndriyBarskyi)
[![@lhalam](https://avatars.githubusercontent.com/u/51734891?s=100&v=4)](https://github.com/nataskrypak)
[![@lhalam](https://avatars.githubusercontent.com/u/44065623?s=100&v=4)](https://github.com/Nadya101) 
[![@lhalam](https://avatars.githubusercontent.com/u/81072407?s=100&v=4)](https://github.com/andriy66)
[![@lhalam](https://avatars.githubusercontent.com/u/62646603?s=100&v=4)](https://github.com/Pidstavskiy)
[![@lhalam](https://avatars3.githubusercontent.com/u/3837059?s=100&v=4)](https://github.com/MakKeywa)  

## Support

Reach out to me at one of the following places!

- Website at <a href="https://speak-ukrainian.org.ua/" target="_blank">`Навчай українською`</a>
- Facebook at <a href="https://www.facebook.com/teach.in.ukrainian
" target="_blank">`Навчай українською`</a>
- Insert more social links here.

---

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2020 © <a href="https://softserve.academy/" target="_blank"> SoftServe IT Academy</a>.
