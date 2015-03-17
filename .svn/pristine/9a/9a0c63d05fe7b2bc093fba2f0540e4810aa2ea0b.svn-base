(function() {
    'use strict';

    angular
        .module('efs.core')
        .constant('availableTemplates', availableTemplates)
        .constant('AUTH_EVENTS', {
          loginSuccess: 'auth-login-success',
          loginFailed: 'auth-login-failed',
          logoutSuccess: 'auth-logout-success',
          notAuthenticated: 'auth-not-authenticated',
          notAuthorized: 'auth-not-authorized'
        })
        .constant('LOCATION_TYPES', {
          "1": {
              text: "STORE"
          },
          "2": {
              text: "DC"
          },
          "3": {
              text: "CORPORATE"
          },
          "4": {
              text: "CUSTOMER CONTACT CENTER"
          },
          "5": {
              text: "TRAINING CENTER"
          },
          "6": {
              text: "TECHNOLOGY CENTER"
          },
          "7": {
              text: "TRANSPORTATION FACILITY"
          },
          "8": {
              text: "COMPETITOR STORE"
          },
          "9": {
              text: "VENDOR DC"
          },
          "10": {
              text: "VENDOR FACTORY"
          },
          "12": {
              text: "VENDOR BOTH DC AND FACTORY"
          },
          "13": {
              text: "RDC",
              icon: {
                shape: "circle",
                color: "#f96302"
              }
          },
          "14": {
              text: "SDC"
          },
          "15": {
              text: "BDC"
          },
          "16": {
              text: "DFC"
          },
          "17": {
              text: "IFC"
          },
          "18": {
              text: "TRANSLOAD"
          }
        });

    function availableTemplates() {
      return [
          {
              'text': 'Location',
              'href': 'templates/EFS_Location_Template.csv'
          },
          {
              'text': 'Order Group',
              'href': 'templates/Order_Group_Template.csv'
          },
          {
              'text': 'Load Group Parameters',
              'href': 'templates/LG_Parm_Template.csv'
          },
          {
              'text': 'Vendor Parameters',
              'href': 'templates/Vndr_Parm_Template.csv'
          },
          {
              'text': 'Route',
              'href': 'templates/Route_Template.csv'
          },
          {
              'text': 'Schedule',
              'href': 'templates/Schedule_Template.csv'
          }
      ];
    }
})();
