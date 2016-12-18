angular.module("openspecimen")
  .directive("osClearfix", function($timeout) {
    return {
      restrict: 'A',

      link: function(scope, element, attrs) {
        $timeout(addClearfix, 0);

        function addClearfix() {
          var nthChild = attrs.osClearfix;
          var length = element.children().length;

          angular.forEach(element.children(), function(child, idx) {
            if ((idx + 1) % nthChild == 0 &&  (idx + 1) < length) {
              $(child).after('<div class="clearfix"></div>');
            }
          });
        }
      }
    }
  });
