module.exports = function(grunt) {

  grunt.initConfig({
    browserify: {
      dist: {
        options: {
          transform: [["babelify", { "stage": 0 }]]
        },
        files: {
          "build/bundle.js": "src/main.js"
        }
      }
    },
    htmlmin: {
      dist: {
        options: {
          removeComments: true,
          collapseWhitespace: true
        },
        files: [{
          "expand": true,
          "cwd": "src/",
          "src": ["**/*.html"],
          "dest": "build/",
          "ext": ".html"
        }]
      }
    },
    watch: {
      scripts: {
        files: "src/*.js",
        tasks: ["browserify"]
      },
      html: {
        files: "src/*.html",
        tasks: ["htmlmin"]
      }
    },
    babel: {
        options: {
            sourceMap: true,
            presets: ['es2015']
        },
        dist: {
            files: {
                'dist/app.js': 'main.js'
            }
        }
    }
  });

  grunt.loadNpmTasks("grunt-browserify");
  grunt.loadNpmTasks("grunt-contrib-watch");
  grunt.loadNpmTasks("grunt-contrib-htmlmin");
  grunt.loadNpmTasks("grunt-babel");

  grunt.registerTask("default", ["babel"]);
};