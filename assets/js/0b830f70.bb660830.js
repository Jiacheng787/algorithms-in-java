"use strict";(self.webpackChunkalgorithm_java=self.webpackChunkalgorithm_java||[]).push([[3223],{3905:function(e,t,r){r.d(t,{Zo:function(){return s},kt:function(){return m}});var n=r(7294);function o(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function a(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function c(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?a(Object(r),!0).forEach((function(t){o(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):a(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function i(e,t){if(null==e)return{};var r,n,o=function(e,t){if(null==e)return{};var r,n,o={},a=Object.keys(e);for(n=0;n<a.length;n++)r=a[n],t.indexOf(r)>=0||(o[r]=e[r]);return o}(e,t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(n=0;n<a.length;n++)r=a[n],t.indexOf(r)>=0||Object.prototype.propertyIsEnumerable.call(e,r)&&(o[r]=e[r])}return o}var u=n.createContext({}),l=function(e){var t=n.useContext(u),r=t;return e&&(r="function"==typeof e?e(t):c(c({},t),e)),r},s=function(e){var t=l(e.components);return n.createElement(u.Provider,{value:t},e.children)},p={inlineCode:"code",wrapper:function(e){var t=e.children;return n.createElement(n.Fragment,{},t)}},f=n.forwardRef((function(e,t){var r=e.components,o=e.mdxType,a=e.originalType,u=e.parentName,s=i(e,["components","mdxType","originalType","parentName"]),f=l(r),m=o,d=f["".concat(u,".").concat(m)]||f[m]||p[m]||a;return r?n.createElement(d,c(c({ref:t},s),{},{components:r})):n.createElement(d,c({ref:t},s))}));function m(e,t){var r=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var a=r.length,c=new Array(a);c[0]=f;var i={};for(var u in t)hasOwnProperty.call(t,u)&&(i[u]=t[u]);i.originalType=e,i.mdxType="string"==typeof e?e:o,c[1]=i;for(var l=2;l<a;l++)c[l]=r[l];return n.createElement.apply(null,c)}return n.createElement.apply(null,r)}f.displayName="MDXCreateElement"},3508:function(e,t,r){r.r(t),r.d(t,{assets:function(){return s},contentTitle:function(){return u},default:function(){return m},frontMatter:function(){return i},metadata:function(){return l},toc:function(){return p}});var n=r(7462),o=r(3366),a=(r(7294),r(3905)),c=["components"],i={sidebar_position:9},u="Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II",l={unversionedId:"\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II",id:"\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II",title:"Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II",description:"\u8fd9\u4e00\u9898\u662f\u7b2c 74 \u9898\u7684\u52a0\u5f3a\u7248\u3002\u7b2c 74 \u9898\u4e2d\u7684\u4e8c\u7ef4\u77e9\u9635\u5b8c\u5168\u662f\u4e00\u4e2a\u6709\u5e8f\u7684\u4e00\u7ef4\u77e9\u9635\uff0c\u4f46\u662f\u8fd9\u4e00\u9898\u5982\u679c\u628a\u5b83\u62cd\u6241\u6210\u4e00\u7ef4\uff0c\u5e76\u4e0d\u662f\u6709\u5e8f\u7684\u3002\u9996\u5148\u6bcf\u4e00\u4e2a\u884c\u6216\u8005\u6bcf\u4e00\u5217\u662f\u6709\u5e8f\u7684 \uff0c\u90a3\u4e48\u6211\u4eec\u53ef\u4ee5\u4f9d\u6b21\u5728\u6bcf\u4e00\u884c\u6216\u8005\u6bcf\u4e00\u5217\u4e2d\u5229\u7528\u4e8c\u5206\u53bb\u641c\u7d22\u3002\u8fd9\u6837\u505a\u65f6\u95f4\u590d\u6742\u5ea6\u4e3a O(n log n)\u3002",source:"@site/docs/\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II.md",sourceDirName:"\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7",slug:"/\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II",permalink:"/algorithms-in-java/docs/\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II",editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II.md",tags:[],version:"current",sidebarPosition:9,frontMatter:{sidebar_position:9},sidebar:"tutorialSidebar",previous:{title:"Leetcode 74 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635",permalink:"/algorithms-in-java/docs/\u5fc5\u77e5\u5fc5\u4f1a\u7b97\u6cd5\u6280\u5de7/Leetcode 74 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635"}},s={},p=[],f={toc:p};function m(e){var t=e.components,r=(0,o.Z)(e,c);return(0,a.kt)("wrapper",(0,n.Z)({},f,r,{components:t,mdxType:"MDXLayout"}),(0,a.kt)("h1",{id:"leetcode-240-\u641c\u7d22\u4e8c\u7ef4\u77e9\u9635-ii"},"Leetcode 240 \u641c\u7d22\u4e8c\u7ef4\u77e9\u9635 II"),(0,a.kt)("p",null,"\u8fd9\u4e00\u9898\u662f\u7b2c 74 \u9898\u7684\u52a0\u5f3a\u7248\u3002\u7b2c 74 \u9898\u4e2d\u7684\u4e8c\u7ef4\u77e9\u9635\u5b8c\u5168\u662f\u4e00\u4e2a\u6709\u5e8f\u7684\u4e00\u7ef4\u77e9\u9635\uff0c\u4f46\u662f\u8fd9\u4e00\u9898\u5982\u679c\u628a\u5b83\u62cd\u6241\u6210\u4e00\u7ef4\uff0c\u5e76\u4e0d\u662f\u6709\u5e8f\u7684\u3002\u9996\u5148\u6bcf\u4e00\u4e2a\u884c\u6216\u8005\u6bcf\u4e00\u5217\u662f\u6709\u5e8f\u7684 \uff0c\u90a3\u4e48\u6211\u4eec\u53ef\u4ee5\u4f9d\u6b21\u5728\u6bcf\u4e00\u884c\u6216\u8005\u6bcf\u4e00\u5217\u4e2d\u5229\u7528\u4e8c\u5206\u53bb\u641c\u7d22\u3002\u8fd9\u6837\u505a\u65f6\u95f4\u590d\u6742\u5ea6\u4e3a O(n log n)\u3002"),(0,a.kt)("p",null,"\u8fd8\u6709\u4e00\u4e2a\u6a21\u62df\u7684\u89e3\u6cd5\u3002\u901a\u8fc7\u89c2\u5bdf\uff0c\u6211\u4eec\u53d1\u73b0\u4e86\u8fd9\u4e2a\u77e9\u9635\u7684\u4e00\u4e2a\u7279\u70b9\uff0c\u6700\u53f3\u8fb9\u4e00\u5217\u7684\u5143\u7d20\u662f\u672c\u884c\u4e2d\u6700\u5927\u7684\u5143\u7d20\uff0c\u6240\u4ee5\u6211\u4eec\u53ef\u4ee5\u5148\u4ece\u6700\u53f3\u8fb9\u4e00\u5217\u5f00\u59cb\u627e\u5230\u7b2c\u4e00\u4e2a\u6bd4 target \u5143\u7d20\u5927\u7684\u5143\u7d20\uff0c\u8fd9\u4e2a\u5143\u7d20\u6240\u5728\u7684\u884c\uff0c\u662f\u6211\u4eec\u63a5\u7740\u8981\u641c\u7d22\u7684\u3002\u5728\u884c\u4e2d\u641c\u7d22\u662f\u4ece\u6700\u53f3\u8fb9\u5f00\u59cb\u5f80\u5de6\u8fb9\u641c\u7d22\uff0c\u65f6\u95f4\u590d\u6742\u5ea6\u662f O(n)\uff0c\u7b97\u4e0a\u4e00\u5f00\u59cb\u5728\u6700\u53f3\u8fb9\u4e00\u5217\u4e2d\u67e5\u627e\u7684\u65f6\u95f4\u590d\u6742\u5ea6\u662f O(m)\uff0c\u6240\u4ee5\u6700\u7ec8\u7684\u65f6\u95f4\u590d\u6742\u5ea6\u4e3a O(m+n)\u3002"),(0,a.kt)("blockquote",null,(0,a.kt)("p",{parentName:"blockquote"},"\u603b\u7ed3\u4e00\u4e0b\u5c31\u662f\u4ece\u77e9\u9635\u7b2c\u4e00\u884c\u6700\u53f3\u4fa7\u5f00\u59cb\u67e5\u627e\uff0c\u5f53\u524d\u503c\u6bd4 target \u5927\u5f80\u5de6\u8d70\uff0c\u6bd4 target \u5c0f\u7684\u8bdd\u5f80\u4e0b\u8d70")),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-go"},"func searchMatrix(matrix [][]int, target int) bool {\n    if len(matrix) == 0 {\n        return false\n    }\n    row, col := 0, len(matrix[0]) - 1\n    for col >= 0 && row <= len(matrix) - 1 {\n        if target == matrix[row][col] {\n            return true\n        } else if target > matrix[row][col] {\n            row++\n        } else {\n            col--\n        }\n    }\n    return false\n}\n")))}m.isMDXComponent=!0}}]);