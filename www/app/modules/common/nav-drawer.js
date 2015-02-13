angular.module('openspecimen')
  .directive('osNavDrawer', function($compile, osNavDrawerSvc) {
    function getNavHeader() {
      var div = angular.element('<div/>').addClass('os-page-hdr');

      var navBtn = angular.element('<button/>')
        .addClass('os-nav-button')
        .append('<span class="fa fa-bars"></span>');

      var title = angular.element('<h3/>')
        .addClass('os-title')
        .css('margin', 0)
        .append('Navigate To');

      div.append(navBtn).append(title);
      return div;
    }

    return {
      restrict: 'A',

      link: function(scope, element, attrs) {
        element.find('ul').addClass('os-menu-items');
        element.find('ul').on('click', function() {
          osNavDrawerSvc.toggle();
        });

        element.addClass('os-nav-drawer')
          .prepend(getNavHeader());

        element.after(angular.element('<div/>').addClass('os-nav-drawer-overlay'));

        element.removeAttr('os-nav-drawer');

        osNavDrawerSvc.setDrawer(element);
        $compile(element)(scope);
      }
    };
  })
  .directive('osNavButton', function(osNavDrawerSvc) {
    return {
      restrict: 'AC',
      link: function(scope, element, attrs) {
        element.on('click', function() {
          osNavDrawerSvc.toggle();
        });
      }
    };
  })
  .factory('osNavDrawerSvc', function() {
    var drawerEl = undefined;
    return {
      setDrawer: function(drawer) {
        drawerEl = drawer;
      },

      toggle: function() {
        drawerEl.toggleClass('active');
      }
    }
  });
