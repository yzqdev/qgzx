const path = require(`path`);
const nodeEnv = process.env.NODE_ENV;
const port = 4300;
const nodeMode = process.env.VUE_APP_BUILDMODE;
const resolve = (dir) => path.join(__dirname, dir);
const target = process.env.VUE_APP_URL;

const externals = {
  vue: "Vue",
  "vue-router": "VueRouter",
  vuex: "Vuex",
  axios: "axios",
  echarts: "echarts",
  "element-ui": "ELEMENT",
};

const cdn = {
  css: ["https://cdn.jsdelivr.net/npm/element-ui/lib/theme-chalk/index.css"],
  js: [
    "https://cdn.jsdelivr.net/npm/vue/dist/vue.js",
    "https://cdn.jsdelivr.net/npm/vue-router/dist/vue-router.min.js",
    "https://cdn.jsdelivr.net/npm/vuex/dist/vuex.min.js",
    "https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js",
    "https://cdn.jsdelivr.net/npm/element-ui/lib/index.js",
    "https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js",
    "https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js",
    "https://cdn.jsdelivr.net/npm/echarts/map/js/china.js",
    "https://cdn.jsdelivr.net/npm/echarts/map/js/world.js",
  ],
};

const devProxy = [`/api`, `/`]; // 代理
// 生成代理配置对象
const proxyObj = {};
devProxy.forEach((value, index) => {
  proxyObj[value] = {
    ws: false,
    target: target,
    // 开启代理：在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
    changeOrigin: true,
    pathRewrite: {
      [`^${value}`]: value,
    },
  };
});
// Const FileManagerPlugin = require("filemanager-webpack-plugin");
const isProduction = nodeEnv === `production`;
const publicPathFolderMap = new Map([
  [`development`, `/dist/`],
  [`devbuild`, `/dist/`],
  [`production`, `/`],
]);
module.exports = {
  // 项目部署的基础路径
  // 我们默认假设你的应用将会部署在域名的根部，
  // 比如 https://www.my-app.com/
  // 如果你的应用时部署在一个子路径下，那么你需要在这里
  // 指定子路径。比如，如果你的应用部署在
  // https://www.foobar.com/my-app/
  // 那么将这个值改为 `/my-app/`
  // PublicPath: process.env.NODE_ENV === `production` ? `/` : `/dist/`,
  publicPath: publicPathFolderMap.get(nodeMode),

  // 将构建好的文件输出到哪里
  outputDir: `dist`,
  // OutputDir: resolve("./dist"),

  // 放置静态资源的地方 (js/css/img/font/...)
  assetsDir: `static`,
  // 默认起始页文件
  indexPath: `index.html`,

  // 默认在生成的静态资源文件名中包含hash以控制缓存
  filenameHashing: true,
  crossorigin: `use-credentials`,
  // 是否在保存的时候使用 `eslint-loader` 进行检查。
  // 有效的值：`ture` | `false` | `"error"`
  // 当设置为 `"error"` 时，检查出的错误会触发编译失败。
  lintOnSave: false,

  // 使用带有浏览器内编译器的完整构建版本
  // 查阅 https://cn.vuejs.org/v2/guide/installation.html#运行时-编译器-vs-只包含运行时
  // Compiler: false,

  // 是否为生产环境构建生成 source map？
  productionSourceMap: false,

  // 调整内部的 webpack 配置。
  // 查阅 https://github.com/vuejs/vue-docs-zh-cn/blob/master/vue-cli/webpack.md
  chainWebpack: (config) => {
    config.plugin("html").tap((args) => {
      if (process.env.NODE_ENV === "production") {
        args[0].cdn = cdn;
      }
      args[0].cdn = cdn;
      return args;
    });
    config.resolve.alias
      .set(`@`, resolve(`src`))
      .set(`components`, resolve(`src/components`))
      .set(`assets`, resolve(`src/assets`))
      .set(`plugins`, resolve(`src/plugins`));
    // .set("utils", resolve("src/utils"))
    // .set("store", resolve("src/store"))
    // .set("views", resolve("src/views"))
    // 移除 prefetch 插件
    config.plugins.delete(`prefetch`);
    // 移除 preload 插件
    config.plugins.delete(`preload`);
    config.output.chunkFilename(`js/[name].[chunkhash:8].js`);
  },
  configureWebpack: (config) => {
    console.log(`node环境`, nodeEnv);
    config.externals = externals;
    if (isProduction) {
      // 为生产环境修改配置...

      console.log(`生产环境`);
      console.log(`部署模式`, nodeMode);
      // Return {
      //   Externals: {
      //     'vue': 'Vue',
      //     'vue-router': 'VueRouter',
      //     'vuex': 'vuex'
      //   }
      // }
    } else if (nodeEnv === `development`) {
      // 为开发环境修改配置...
      console.log(`开发环境`);
    } else if (nodeEnv === `test`) {
      // 为测试环境修改配置...
      console.log(`测试环境`);
    }
  },

  // CSS 相关选项
  css: {
    // 是否开启 CSS source map？
    sourceMap: isProduction,
    extract: false,
    // 为预处理器的 loader 传递自定义选项。比如传递给
    loaderOptions: {
      less: {
        javascriptEnabled: true,
      },
    },

    // 为所有的 CSS 及其预处理文件开启 CSS Modules。
    // 这个选项不会影响 `*.vue` 文件。
    requireModuleExtension: true,
  },

  // 在生产环境下为 Babel 和 TypeScript 使用 `thread-loader`
  // 在多核机器下会默认开启。
  parallel: require(`os`).cpus().length > 1,

  // 配置 webpack-dev-server 行为。
  devServer: {
    port: port,
    https: false,
    hotOnly: false,
    overlay: {
      warnings: false,
      errors: false,
    },
    open: true,
    proxy: proxyObj,
  },

  // 第三方插件的选项
  // PluginOptions: {
  //   Env: {
  //     TEST: "vue.config.js-->pluginOptions.env:TEST Global Parameters"
  //   },
  //   "style-resources-loader": {
  //     PreProcessor: "less",
  //     Patterns: [path.resolve(__dirname, "./src/assets/less/settings.less")]
  //   }
  // }
};
