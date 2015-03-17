/**
 * Created by HXH6025 on 10/18/2014.
 */

module.exports = function(grunt) {

    // Project configuration.
	grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        watch: {
            js: {
                files: [
                    '**/*.js',
                    'Gruntfile.js',
                    "!**/node_modules/**/*",
                    "!**/coverage/**/*",
                    "!**/report/**/*"
                ],
                tasks: ['plato:report:run'],
                options: {
                  debounceDelay: 60000 * 5,
                }
            },
            //run unit tests with karma (server needs to be already running)
            karma: {
                files: [
                    '**/*.js',
                    //ignore all the mode modules or else they will kill your machine
                    "!**/node_modules/**/*",
                    "!**/coverage/**/*",
                    "!**/report/**/*"
                ],
                tasks: ['karma:unit:run']
            }
        },
        karma: {
            unit: {
                configFile: 'karma.conf.js',
                background: true
            }
        },
        plato: {
            report: {
                options: {
                    // Task-specific options go here.
                },
                files: {
                    // Target-specific file lists and/or options go here.
                    'report/plato': [
                        '**/*.js',
                        '!**/node_modules/**/*',
                        '!**/coverage/**/*',
                        '!**/libraries/**/*',
                        '!**/report/**/*'
                    ]
                }
            }
        }
    });
 
	// Load the Grunt plugins.
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-run');
    grunt.loadNpmTasks('grunt-karma');
    grunt.loadNpmTasks('grunt-plato');
    grunt.registerTask('default', ['watch', 'karma', 'plato:report']);
       
};