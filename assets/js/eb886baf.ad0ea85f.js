"use strict";(self.webpackChunkalgorithm_java=self.webpackChunkalgorithm_java||[]).push([[9797],{3905:function(e,t,n){n.d(t,{Zo:function(){return l},kt:function(){return d}});var r=n(7294);function o(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function c(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function a(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?c(Object(n),!0).forEach((function(t){o(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):c(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function i(e,t){if(null==e)return{};var n,r,o=function(e,t){if(null==e)return{};var n,r,o={},c=Object.keys(e);for(r=0;r<c.length;r++)n=c[r],t.indexOf(n)>=0||(o[n]=e[n]);return o}(e,t);if(Object.getOwnPropertySymbols){var c=Object.getOwnPropertySymbols(e);for(r=0;r<c.length;r++)n=c[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(o[n]=e[n])}return o}var u=r.createContext({}),s=function(e){var t=r.useContext(u),n=t;return e&&(n="function"==typeof e?e(t):a(a({},t),e)),n},l=function(e){var t=s(e.components);return r.createElement(u.Provider,{value:t},e.children)},p={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},f=r.forwardRef((function(e,t){var n=e.components,o=e.mdxType,c=e.originalType,u=e.parentName,l=i(e,["components","mdxType","originalType","parentName"]),f=s(n),d=o,m=f["".concat(u,".").concat(d)]||f[d]||p[d]||c;return n?r.createElement(m,a(a({ref:t},l),{},{components:n})):r.createElement(m,a({ref:t},l))}));function d(e,t){var n=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var c=n.length,a=new Array(c);a[0]=f;var i={};for(var u in t)hasOwnProperty.call(t,u)&&(i[u]=t[u]);i.originalType=e,i.mdxType="string"==typeof e?e:o,a[1]=i;for(var s=2;s<c;s++)a[s]=n[s];return r.createElement.apply(null,a)}return r.createElement.apply(null,n)}f.displayName="MDXCreateElement"},7799:function(e,t,n){n.r(t),n.d(t,{assets:function(){return l},contentTitle:function(){return u},default:function(){return d},frontMatter:function(){return i},metadata:function(){return s},toc:function(){return p}});var r=n(7462),o=n(3366),c=(n(7294),n(3905)),a=["components"],i={sidebar_position:10},u="Leetcode 856 \u62ec\u53f7\u7684\u5206\u6570",s={unversionedId:"\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 856 \u62ec\u53f7\u7684\u5206\u6570",id:"\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 856 \u62ec\u53f7\u7684\u5206\u6570",title:"Leetcode 856 \u62ec\u53f7\u7684\u5206\u6570",description:"",source:"@site/docs/\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 856 \u62ec\u53f7\u7684\u5206\u6570.md",sourceDirName:"\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7",slug:"/\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 856 \u62ec\u53f7\u7684\u5206\u6570",permalink:"/algorithms-in-java/docs/\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 856 \u62ec\u53f7\u7684\u5206\u6570",editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 856 \u62ec\u53f7\u7684\u5206\u6570.md",tags:[],version:"current",sidebarPosition:10,frontMatter:{sidebar_position:10},sidebar:"tutorialSidebar",previous:{title:"Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II",permalink:"/algorithms-in-java/docs/\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II"}},l={},p=[],f={toc:p};function d(e){var t=e.components,n=(0,o.Z)(e,a);return(0,c.kt)("wrapper",(0,r.Z)({},f,n,{components:t,mdxType:"MDXLayout"}),(0,c.kt)("h1",{id:"leetcode-856-\u62ec\u53f7\u7684\u5206\u6570"},"Leetcode 856 \u62ec\u53f7\u7684\u5206\u6570"),(0,c.kt)("pre",null,(0,c.kt)("code",{parentName:"pre",className:"language-go"},'func scoreOfParentheses(s string) int {\n    stack := []int{0} // \u521d\u59cb\u5316\uff0c\u5c06 `0` \u653e\u5165\u7b54\u6848\u4e2d\n    for _, char := range s {\n        if string(char) == "(" {\n            // \u9047\u5230 `(` \u5219\u5b58\u5165\u4e00\u4e2a `0`\n            stack = append(stack, 0)\n        } else {\n            // \u9047\u5230 `)` \u53d6\u51fa\u6808\u9876\u5143\u7d20\n            l := len(stack)\n            cur := stack[l-1]\n            stack = stack[:l-1]\n            if cur == 0 {\n                // \u6808\u9876\u5143\u7d20 cur == 0\n                // \u5373\u5f53\u524d `)`\u7684\u524d\u4e00\u5143\u7d20\u662f `(`\n                // \u6839\u636e `()` \u5f97\u4e00\u5206\u7684\u89c4\u5219\uff0c\u672c\u6b21\u64cd\u4f5c\u5206\u503c\u4e3a `1`\n                stack[l-2] = stack[l-2] + 1\n            } else {\n                // \u6808\u9876\u5143\u7d20 cur != 0\n                // \u5373\u5f53\u524d `)` \u4e0e\u5176\u5339\u914d\u7684 `(` \u4e2d\u95f4\u76f8\u9694\u4e86\u5176\u4ed6\u5b57\u7b26\n                // \u6839\u636e `(A)` \u7684\u5f97\u5206\u89c4\u5219\uff0c\u6b64\u65f6\u5f97\u5206\u4e3a `cur * 2`\n                stack[l-2] = stack[l-2] + cur*2\n            }\n        }\n    }\n    return stack[0]\n}\n')))}d.isMDXComponent=!0}}]);